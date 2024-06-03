package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/3
 *@Time: 9:48
 * 给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode394 {
    public static void main(String[] args) {

    }
    //注意括号嵌套和字符串转数字的时候会连续
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<String> stack_ans = new ArrayDeque<>();
        Deque<Integer> stack_num = new ArrayDeque<>();
        int num = 0;
        for(char c : s.toCharArray()) {
            if(c == '[') {
                stack_num.push(num);
                num = 0;
                stack_ans.push(ans.toString());
                ans = new StringBuilder();
            }else if(c == ']') {
                int cur_num = stack_num.pop();
                StringBuilder tmp = new StringBuilder();
                for(int i = 0; i < cur_num; i++) {
                    tmp.append(ans);
                }
                ans = new StringBuilder(stack_ans.pop() + tmp.toString());
            }else if(c - '0' >= 0 && c - '9' <= 0){
                num = num * 10 + c - '0';
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
