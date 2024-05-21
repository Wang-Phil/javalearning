package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/21
 *@Time: 20:56
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */

import java.util.Arrays;

public class Leetcode416 {
    public static void main(String[] args) {

    }
    //分割等和子集，采用0-1背包问题进行求解
    //方法1，记忆化搜索
    public boolean canPartition(int[] nums) {
        //分割等和子集
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        int [][]memo = new int[n][sum/2 + 1];
        for(int []row : memo){
            Arrays.fill(row, -1);
        }
        return dfs(n-1, sum/2, nums, memo);
    }
    public boolean dfs(int i, int j, int[] nums, int[][] memo) {
        if(i < 0){
            return j == 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j] == 1;
        }
        boolean result = j >= nums[i] && dfs(i-1, j-nums[i], nums, memo) || dfs(i-1, j, nums, memo);
        memo[i][j] = result ? 1 : 0;
        return result;
    }
}
