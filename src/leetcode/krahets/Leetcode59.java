package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/14
 *@Time: 16:35
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */

import java.util.Arrays;

public class Leetcode59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
    //螺旋矩阵2
    public static int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num++;
            }
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = num++;
            }
            if (++left > right) break;
        }
        return ans;
    }
}
