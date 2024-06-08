package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/8
 *@Time: 9:19
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：

选择 nums 中最前面两个元素并且删除它们。
选择 nums 中最后两个元素并且删除它们。
选择 nums 中第一个和最后一个元素并且删除它们。
一次操作的 分数 是被删除元素的和。

在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。

请你返回按照上述要求 最多 可以进行的操作次数。
 */

import java.util.Arrays;

public class Leetcode3040 {
    public static void main(String[] args) {

    }
    //相同分数的最大操作数目II
    private int[] nums;
    private int[][] memo;
    private boolean done;
    public int maxOperations(int[] nums) {
        //动态规划的记忆化搜索实现
        int n = nums.length;
        memo = new int[n][n];
        this.nums = nums;

        int res1 = helper(1, n-1, nums[0] + nums[1]);       //删除前两个数
        int res2 = helper(0, n-3, nums[n-1] + nums[n-2]);   //删除后两个数
        int res3 = helper(1, n-2, nums[0] + nums[n-1]);     //删除第一个数和最后一个数
        return Math.max(Math.max(res1,res2),res3)+1;
    }

    private int helper(int i, int j, int target) {
        if (done) { // 说明之前已经算出了 res = n / 2
            return 0; // 返回任意 <= n/2 的数均可
        }

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(i,j,target);
    }

    private int dfs(int i, int j, int target) {
        if(done)    return 0;
        if(i >= j){
            done = true;
            return 0;
        }
        if(memo[i][j] != -1) return memo[i][j];
        int res = 0;
        if(nums[i] + nums[i+1] == target){      //删除前两个数
            res = Math.max(res,dfs(i+2,j,target)+1);
        }
        if(nums[j] + nums[j-1] == target){      //删除后两个数
            res = Math.max(res,dfs(i,j-2,target)+1);
        }
        if(nums[i] + nums[j] == target){        //删除第一个数和最后一个数
            res = Math.max(res,dfs(i+1,j-1,target)+1);
        }
        return memo[i][j] = res;
    }
}
