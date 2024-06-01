package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/1
 *@Time: 10:06
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。
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
        if(min_stack.isEmpty() || val < min_stack.peek()) {
            min_stack.push(val);
        }
        stack.push(val);
    }
    //void pop() 删除堆栈顶部的元素
    public void pop() {
        if(stack.pop() == min_stack.peek()) {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */