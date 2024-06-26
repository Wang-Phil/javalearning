package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/17
 *@Time: 10:29
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */

public class Leetcode198 {
    public static void main(String[] args) {

    }
    //打家劫舍
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        int dpn = Math.max(dp1, dp2);
        for (int i = 2; i < n; i++) {
            dpn = Math.max(dp1 + nums[i], dp2);
            dp1 = dp2;
            dp2 = dpn;
        }
        return dp2;
    }
}
