package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/30
 *@Time: 10:38
 * 给你一个非负整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */

public class Leetcode494 {
    public static void main(String[] args) {

    }
    //目标和
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        //第一感觉是回溯
        backTracking(nums, 0, target);
        return count;
    }
    private void backTracking(int[] nums, int start, int target) {
        if (start == nums.length) {
            if(target == 0)
                count++;
        }
            backTracking(nums, start + 1, target - nums[start]);
            backTracking(nums, start + 1, target + nums[start]);
    }
}
