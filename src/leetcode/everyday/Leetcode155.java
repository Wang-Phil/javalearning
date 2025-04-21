package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/12
 *@Time: 21:04
 */

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode155 {
    public static void main(String[] args) {

    }
}
class MinStack {
    //借用一个辅助栈来存储
    Deque<Integer> stack;
    Deque<Integer> min_stack;
    //MinStack() 初始化堆栈对象
    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
    }
    //void push(int val) 将元素val推入堆栈
    public void push(int val) {
        if (min_stack.isEmpty() || val <= min_stack.peek()) {//如果当前元素小于等于当前min栈顶元素，进加入到最小栈当中,注意是小于等于
            min_stack.push(val);
        }
        stack.push(val);//将当前元素入栈
    }
    //void pop() 删除堆栈顶部的元素
    public void pop() {
        if (stack.pop().equals(min_stack.peek())) { //如果栈顶元素与最小辅助栈元素的栈顶元素相同，就一起抛出
            min_stack.pop();
        }
    }
    //int top() 获取堆栈顶部的元素
    public int top() {
        return stack.peek();        //返回栈顶元素
    }
    //int getMin() 获取堆栈中的最小元素
    public int getMin() {
        return min_stack.peek();        //返回最小值栈顶元素
    }
}