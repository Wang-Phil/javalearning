package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/24
 *@Time: 10:08
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetcode496 {
    public static void main(String[] args) {

    }
    //下一个更大元素1
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //单调栈的思路
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //从后往前遍历，采用单调递减栈
        int n = nums2.length;
        for(int i = n - 1; i >= 0; i--) {
            int num = nums2[i];
            //当栈中元素比当前遍历元素小的时候，这个栈里面的元素肯定不是下一个最大值，直接抛出
            while(!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        //遍历第一个数组nums1,找到存储的下一个更大值
        int[] res = new int[nums1.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
