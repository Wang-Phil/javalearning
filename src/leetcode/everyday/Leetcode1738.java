package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/26
 *@Time: 10:16
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。

矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。

请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 */

import java.util.Arrays;

public class Leetcode1738 {
    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}}, 1));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        //二维前缀异或和
        int rows = matrix.length;
        int cols = matrix[0].length;
        int sum[][] = new int[rows+1][cols+1];
        int res[] = new int[rows*cols];
        int idx = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                sum[i+1][j+1] = sum[i][j] ^ sum[i+1][j] ^ sum[i][j+1] ^ matrix[i][j];
                res[idx++] = sum[i+1][j+1];
            }
        }
        Arrays.sort(res);
        return res[idx-k];
    }
}
