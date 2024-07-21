package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/21
 *@Time: 20:30
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。

注意，删除一个元素后，子数组 不能为空。
 */

import java.util.Arrays;

public class Leetcode1186 {
    public static void main(String[] args) {
//        System.out.println(maximumSum(new int[]{1,-2,0,3}));
    }
    //删除一次得到子数组最大值
    private int[] arr;
    private int [][] memo;
    public int maximumSum(int[] arr) {
        //记忆化搜索翻译到dp算法
        this.arr = arr;
        int ans = Integer.MIN_VALUE;
        memo = new int[arr.length][2];
        for(int row[] : memo){      //初始化记忆化数组
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans,Math.max(dfs(i,0),dfs(i, 1)));
        }
        return ans;
    }
    private int dfs(int i, int j) {
        if(i < 0) return Integer.MIN_VALUE/2;           //防止负数相加溢出
        if(memo[i][j] != Integer.MIN_VALUE) return memo[i][j];      //之前计算过
        if(j == 0) return memo[i][j] = Math.max(dfs(i-1, 0), 0) + arr[i];
        return memo[i][j] = Math.max(dfs(i-1, 1)+ arr[i], dfs(i-1, 0) );
    }

    //将其改造成dp数组的形式
    public int maximumSum1(int[] arr) {
        //记忆化搜索翻译到dp算法
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[arr.length+1][2];
        Arrays.fill(dp[0], Integer.MIN_VALUE/2);
        for (int i = 0; i < arr.length; i++) {
            dp[i+1][0] = Math.max(dp[i][0], 0) + arr[i];
            dp[i+1][1] = Math.max(dp[i][1]+arr[i], dp[i][0]);
            ans = Math.max(ans, Math.max(dp[i+1][0], dp[i+1][1]));
        }
        return ans;
    }
}
