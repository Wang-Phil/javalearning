package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/6
 *@Time: 10:05
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的 回文串的长度。
在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 */

import java.util.HashMap;

public class Leetcode409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aa"));
    }
    //最长回文串
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int ans = 0;
        int start = 0;
        for(int value : map.values()){
            if(value % 2 == 0) ans += value;
            else{
                ans += value - 1;
                if(start == 0)
                    start = 1;
            }
        }
        return start == 0 ? ans : ans + 1;
    }
}
