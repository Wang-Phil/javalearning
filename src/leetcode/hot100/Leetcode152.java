package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/19
 *@Time: 8:56
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
子数组
（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

测试用例的答案是一个 32-位 整数。
 */

public class Leetcode152 {
    public static void main(String[] args) {

    }
    //乘积最大子数组
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int minNum = nums[0], maxNum = nums[0];
        for (int i = 1; i < n; i++) {
            int tempMax = maxNum;
            maxNum = Math.max(maxNum * nums[i], Math.max(minNum * nums[i], nums[i]));
            minNum = Math.min(minNum * nums[i], Math.min(nums[i], tempMax * nums[i]));
            res = Math.max(res, maxNum);
        }
        return res;
    }


    //第二种思路
    public int maxProduct1(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int pro = 1;
        for (int i = 0; i < n; i++) {
            pro *= nums[i];
            max = Math.max(max, pro);
            if(nums[i] == 0){
                pro = 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            pro *= nums[i];
            max = Math.max(max, pro);
            if(nums[i] == 0){
                pro = 1;
            }
        }
        return max;
    }
}
