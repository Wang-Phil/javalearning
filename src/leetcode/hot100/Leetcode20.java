package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/11
 *@Time: 11:30
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 */

import java.util.*;

public class Leetcode20 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        int n = s.length();
        if(n % 2 != 0) return false;
        char str[] = s.toCharArray();
        for(char c : str) {
            if(!pairs.containsKey(c)) {     //如果是左括号，就入栈
                stack.push(c);
            }else{                          //右括号就进行匹配
                if(stack.isEmpty() ||  stack.peek() != pairs.get(c)) {     //如果不匹配或者栈为空了，就返回false
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();            //最后如果栈为空了，就是正确的
    }

    public boolean isValid1(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()) {         //遍历字符串，如果是左括号就把右括号入栈，如果是右括号，就判断栈是否为空，然后判断栈顶元素是否与当前括号匹配，最后直接判断栈是否为空
            if(c == '(') {
                stack.push(')');
            }else if(c == '[') {
                stack.push(']');
            }else if(c == '{') {
                stack.push('}');
            }else{
                if(stack.isEmpty() ||  stack.peek() != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
