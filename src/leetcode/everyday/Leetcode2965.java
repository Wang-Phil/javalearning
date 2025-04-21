package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/31
 *@Time: 9:45
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
任务是找出重复的数字a 和缺失的数字 b 。
返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 */

public class Leetcode2965 {
    public static void main(String[] args) {

    }
    //找出缺失和重复的数字
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        //第一种方法，计数统计
        int n = grid.length;
        int nums[] = new int[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[grid[i][j]-1]++;
            }
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < n*n; i++) {
            if(nums[i] == 0) b = i;
            if(nums[i] == 2) a = i;
        }
        return new int[]{a,b};
    }

    public int[] findMissingAndRepeatedValues2(int[][] grid) {
        //第二种方法，数学方法
        int n = grid.length;
        int m = n * n;
        int d1 = -m*(m+1)/2;
        long d2 = (long)-m*(m+1)*(m*2+1) / 6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d1 += grid[i][j];
                d2 += grid[i][j] * grid[i][j];
            }
        }
        int d = (int)d2/d1;
        return new int[]{(d+d1)/2, (d-d1)/2};
    }
}
