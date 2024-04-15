package leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Leetcode42 {
    //接雨水，hard题目，其实并没有很难
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

/*
    public static int trap(int[] height) {
        //前面最大值和后面最大值
        //第一种解法：用两个数组维护前面的最大值和后面的最大值
        int n = height.length;
        int preMax[] = new int[n];
        int sufMax[] = new int[n];
        int ans = 0;
        sufMax[n-1] = height[n-1];
        for(int i = n - 2; i >= 0 ; i--){
            sufMax[i] = Math.max(sufMax[i+1], height[i]);
        }
        preMax[0] = height[0];
        for(int i = 1; i < n; i++){
            preMax[i] = Math.max(preMax[i-1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return ans;
    }
 */

/*
public static int trap(int[] height) {
    //第二种解法是第一种解法的改进版：采用双指针就可以，维护左边的最大值和右边的最大值
    int n = height.length;
    int preMax = height[0];
    int sufMax = height[n-1];
    int left = 0;
    int right = n-1;
    int ans = 0;
    while(left <= right){
        preMax = Math.max(preMax, height[left]);
        sufMax = Math.max(sufMax, height[right]);
        //当左边的max小于右边的max，左边的就可以往前推进，不会遗漏没有计算的雨水
        if(preMax < sufMax){
            ans += preMax - height[left];
            left++;
        }
        //当右边的max小于左边的max，右边的就可以往前推进，不会遗漏没有计算的雨水
        else{
            ans += sufMax - height[right];
            right--;
        }
    }
    return ans;
}
 */
    public static int trap(int[] height) {
        //前面两种解法是采用竖着计算的方法，这里采用单调栈进行横向的计算，大致的方法就是，找上一个更大的元素，在找的过程中填坑
        int n = height.length;
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int num1 = stack.pop();
                if(stack.isEmpty()) break;
                int num2 = stack.peek();
                int h = Math.min(height[num2],height[i]) - height[num1];
                int w = i - num2  - 1;
                ans += h * w;
            }
            stack.push(i);
        }
        return ans;
    }

}
