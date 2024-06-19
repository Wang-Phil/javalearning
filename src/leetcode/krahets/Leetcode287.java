package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/19
 *@Time: 15:33
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。

你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */

public class Leetcode287 {
    public static void main(String[] args) {

    }
    //寻找重复数
    public int findDuplicate(int[] nums) {
        //重点：不修改数组，只能用常量级的额外空间，将其想象成链表，找到环的入口
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = slow;
        int pre2 = 0;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
