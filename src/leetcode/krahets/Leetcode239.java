package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/11
 *@Time: 9:22
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。
 */

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode239 {
    public static void main(String[] args) {

    }
    //滑动窗口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        //滑动窗口加上单调队列可以实现
        int n = nums.length;
        int res[] = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<Integer>();
        //在没有形成窗口的时候
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        //在形成窗口后
        for(int i = k; i < n; i++) {
            //如果要删除的元素刚好是当前最大的元素，需要将当前元素移除
            if(deque.peekFirst() == nums[i-k]) {
                deque.removeFirst();
            }
            //将队尾中较小的最大值移除
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            //将当前元素加入到队列中，然后将队首的元素加入到res中
            deque.addLast(nums[i]);
            res[i-k+1] = deque.peekFirst();
        }
        return res;
    }
}
