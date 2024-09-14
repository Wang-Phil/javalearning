package leetcode;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/9/14
 * @Time: 14:32
 * 给你一个包含若干星号 * 的字符串 s 。
 *
 * 在一步操作中，你可以：
 *
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * 返回移除 所有 星号之后的字符串。
 *
 * 注意：
 *
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 *
 *
 **/
public class Leetcode2390 {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
    public static String removeStars(String s) {
        //栈的应用
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
