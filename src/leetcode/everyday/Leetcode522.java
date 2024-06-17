package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/17
 *@Time: 15:09
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。

特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。

 s 的 子序列可以通过删去字符串 s 中的某些字符实现。

例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 */

import java.util.Arrays;

public class Leetcode522 {
    public static void main(String[] args) {

    }
    //最长特殊序列2
    public int findLUSlength(String[] strs) {
        //先排序
        Arrays.sort(strs, (s1, s2)->(s2.length()-s1.length()));
        int n = strs.length;
        int ans = 0;
        //然后判断是否是其他序列的子序列，如果是，就跳过，这里用到了goto语句
        next:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j && check(strs[j],strs[i])){
                    continue next;
                }
            }
            return strs[i].length();
        }
        return -1;
    }

    private boolean check(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int i = 0;
        for(char c : str1.toCharArray()){
            if(c == str2.charAt(i) && ++i == m){
                return true;
            }
        }
        return false;
    }
}
