package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/3
 *@Time: 10:23
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
你需要按照以下要求，给这些孩子分发糖果：
每个孩子至少分配到 1 个糖果。
相邻两个孩子评分更高的孩子会获得更多的糖果。
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */

import java.util.Arrays;

public class Leetcode135 {
    public static void main(String[] args) {

    }
    //分发糖果
    public int candy(int[] ratings) {
        //左右贪心
        int n = ratings.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int candy = 0;
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 0; i < n - 1; i++) {
            if(ratings[i+1] > ratings[i]) left[i+1] = left[i] + 1;
        }
        for (int i = n-1; i > 0; i--) {
            if(ratings[i-1] > ratings[i]) right[i-1] = right[i] + 1;
        }
        for (int i = 0; i < n; i++) {
            candy += Math.max(left[i], right[i]);
        }
        return candy;
    }
}
