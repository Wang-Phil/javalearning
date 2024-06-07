package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/7
 *@Time: 10:02
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）
 */

public class Leetcode392 {
    public static void main(String[] args) {

    }
    //判断子序列
    public boolean isSubsequence(String s, String t) {
        //双指针解法
        char strs[] = s.toCharArray();
        char strt[] = t.toCharArray();
        int i = 0, j = 0;
        while (i < strs.length && j < strt.length) {
            if (strs[i] == strt[j]) {
                i++;
            }
            j++;
        }
        return i == strs.length;
    }
}
