package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/15
 *@Time: 10:54
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */

public class Leetcode55 {
    public static void main(String[] args) {

    }
    public boolean canJump(int[] nums) {
        //贪心算法
        int maxRight = 0;
        for(int i = 0;  i <= maxRight; i++) {
            maxRight = Math.max(maxRight, i + nums[i]);
            if(maxRight >= nums.length - 1) return true;
        }
        return false;
    }
}
