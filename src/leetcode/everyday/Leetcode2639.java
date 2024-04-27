package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/27
 *@Time: 9:25
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。矩阵中某一列的宽度是这一列数字的最大 字符串长度 。

比方说，如果 grid = [[-10], [3], [12]] ，那么唯一一列的宽度是 3 ，因为 -10 的字符串长度为 3 。
请你返回一个大小为 n 的整数数组 ans ，其中 ans[i] 是第 i 列的宽度。

一个有 len 个数位的整数 x ，如果是非负数，那么 字符串长度 为 len ，否则为 len + 1 。
 *
 */

import java.util.Arrays;

public class Leetcode2639 {
    public static void main(String[] args) {

    }

    /*public int[] findColumnWidth(int[][] grid) {
        //找到每一列，转为字符串，然后求长度即可
        int m = grid.length;
        int n = grid[0].length;
        int ans[] = new int[n];
        for(int j = 0; j < n; j++){//先遍历列
            int maxlen = 0;
            for(int i = 0; i < m; i++){//再遍历行
                int temp = String.valueOf(grid[i][j]).length();
                maxlen = Math.max(maxlen, temp);
            }
            ans[j] = maxlen;
        }
        return ans;
    }*/

    //优化，先找到最大最小值，然后再进行判断即可
    public int[] findColumnWidth(int[][] grid) {
        //找到每一列，转为字符串，然后求长度即可
        int m = grid.length;
        int n = grid[0].length;
        int ans[] = new int[n];
        for(int j = 0; j < n; j++){//先遍历列
            int min = 0;
            int max = 0;
            for(int i = 0; i < m; i++){//再遍历行
                min = Math.min(min, grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }
            int maxlen = 1;
            for(int x = Math.max(max/10, -min); x > 0; x /= 10){
                maxlen++;
            }
            ans[j] = maxlen;
        }
        return ans;
    }
}
