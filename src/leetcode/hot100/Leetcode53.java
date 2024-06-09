package leetcode.hot100;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/18
 *Time: 12:39
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组
是数组中的一个连续部分。
 */

import java.util.Arrays;

//最大子数组之和
public class Leetcode53 {
    public static void main(String[] args){

    }

    public static int maxSubArray(int[] nums) {
        //动态规划dp[ ] = dp[i-1],dp[i-1]+nums[i]
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
