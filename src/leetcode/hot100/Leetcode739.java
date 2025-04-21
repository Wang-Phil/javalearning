package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/13
 *@Time: 10:03
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
    //单调栈，下一个更大的数，这里是从右到左实现的
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {//从后往前的单调栈
                stack.pop();
            }
            if(!stack.isEmpty()){//栈不为空，说明栈顶元素比当前i值温度高
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
    //单调栈，从左到右进行实现
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[n];
        for (int i = 0; i< n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {//从左到右
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }
}
