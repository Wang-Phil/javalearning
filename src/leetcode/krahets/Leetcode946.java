package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/12
 *@Time: 10:19
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 */

import java.util.Stack;

public class Leetcode946 {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{2, 3, 0, 1}, new int[]{0,3,2, 1}));
    }
    //验证栈的顺序
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //思路，模拟
        //在遍历入栈顺序的时候，判断是否可以出栈，最后判断栈是否为空
        Stack<Integer> stack = new Stack<Integer>();
        int n = pushed.length;
        int i = 0;
        for(int num : pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
