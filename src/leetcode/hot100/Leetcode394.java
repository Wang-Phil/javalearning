package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/12
 *@Time: 20:34
 * 给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode394 {
    public static void main(String[] args) {
        System.out.println(decodeString("abc3[cd]xyz"));
    }
    //字符串解码
    public static String decodeString(String s) {
        //本题难点，括号内，嵌套括号,栈进行模拟
        StringBuilder res = new StringBuilder();
        Deque<Integer> nums = new LinkedList<>();
        Deque<String> stack_res = new LinkedList<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                nums.push(num);
                num = 0;
                stack_res.push(res.toString());
                res = new StringBuilder();
            }else if (c == ']') {
                int cur_num = nums.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < cur_num; i++) {//求当前的tmp
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            }else if(c - '0' >= 0 && c - '9' >= 0) {
                num = num * 10 + c - '0';
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
