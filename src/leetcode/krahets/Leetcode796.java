package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/12
 *@Time: 10:12
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。

s 的 旋转操作 就是将 s 最左边的字符移动到最右边。

例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 */

public class Leetcode796 {
    public static void main(String[] args) {

    }
    //旋转字符串
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        StringBuilder sb = new StringBuilder(s+s);
        return sb.toString().contains(goal);
    }
}
