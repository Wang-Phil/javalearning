package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/13
 *@Time: 10:27
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode84 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{0,9}));
    }
    //矩形的最大面积，单调栈+加上哨兵技巧，前后加上0
    public static int largestRectangleArea(int[] heights) {
        //以元素i为高度的最大面积就是右边第一个 heights[right]比当前元素小，左边第一个比当前元素小heights[left],然后宽度计算就是right - left - 1
        //整体采用单调栈的形式，利用两个栈来实现，一个left用来存储左边较小的元素，一个right来存储当前下标i右边较小的元素
        int n = heights.length;
        int left[] = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            while (!stack.isEmpty() && h <= heights[stack.peek()]) {//单调递增栈，如果当前元素小于栈顶，就弹出
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();      //如果栈为空，就赋值为-1，左边界为-1
            stack.push(i);
        }
        int right[] = new int[n];
        stack.clear();//注意清空栈
        for (int i = n - 1; i >= 0; i--) {
            int h = heights[i];
            while (!stack.isEmpty() && h <= heights[stack.peek()]) {//同样是单调递增栈，寻找右边小于栈顶元素的第一个元素
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(right));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }
}
