package leetcode.everyday;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/9/5
 * @Time: 14:25
 *
 * 给你一个字符串 s 。
 *
 * 你的任务是重复以下操作删除 所有 数字字符：
 *
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 *
 *
 **/
public class Leetcode3174 {
    public static void main(String[] args) {
        System.out.println(clearDigits("a1b2c3d4e"));
    }
    //清除数字，采用栈的方式
    public static String clearDigits(String s) {
        LinkedList<Character>  stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
               if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
