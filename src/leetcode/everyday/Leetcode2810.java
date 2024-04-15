package leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version 1.0
 * @auther wangweicheng
 * 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
 * 给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
 * 返回最终笔记本屏幕上输出的字符串。
 */
public class Leetcode2810 {
    public static void main(String[] args) {
        System.out.println(finalString("string"));
    }

    public static String finalString(String s) {
        //反转字符串
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean rev = true;
        for(char ch : s.toCharArray()){
            if(ch == 'i') rev = !rev;
            else if(rev){
                deque.addLast(ch);
            }
            else{
                deque.addFirst(ch);
            }
        }
        for(char ch : deque){
            stringBuilder.append(ch);
        }
        if(!rev){
            stringBuilder = stringBuilder.reverse();
        }
        return stringBuilder.toString();
    }
}
