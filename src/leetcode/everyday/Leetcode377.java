package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/22
 *@Time: 11:46
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
题目数据保证答案符合 32 位整数范围。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode377 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3}, 35));
    }
/*    public static int combinationSum4(int[] nums, int target) {
        //递归+保存递归出现的值，就是记忆化搜索
        int memo[] = new int[target+1];
        Arrays.fill(memo, -1);
        return dfs(nums, target, memo);
    }
    public static int dfs(int nums[], int target, int memo[]){
        if(target == 0) return 1;       //结束了
        if(memo[target] != -1) return memo[target];     //之前计算过
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= target){
                res += dfs(nums, target - nums[i], memo);
            }
        }
        return memo[target] = res; //保存，进行下次的记忆化搜索。
    }*/

    //记忆化搜索转变为递推实现
    public static int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int x : nums){
                if(x <= i){
                    dp[i] += dp[i-x];
                }
            }
        }
        return dp[target];
    }
}
