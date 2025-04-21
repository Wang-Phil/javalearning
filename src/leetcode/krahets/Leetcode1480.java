package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/28
 *@Time: 17:37
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

请返回 nums 的动态和。
 */

public class Leetcode1480 {
    public static void main(String[] args) {

    }
    //一维数组的动态和
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i] + ans[i - 1];
        }
        return ans;
    }
}
