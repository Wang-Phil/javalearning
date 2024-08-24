package leetcode.everyday;

import java.util.HashMap;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/8/24
 * @Time: 11:08
 * 给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。
 *
 * 排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。
 *
 * 返回 s 和 t 之间的 排列差 。
 *
 **/
public class Leetcode3146 {
    public static void main(String[] args) {

    }

    //两个字符串的排列差
    public int findPermutationDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int ans = 0;
        for(int i = 0; i < t.length(); i++) {
            ans += Math.abs(map.get(t.charAt(i)) - i);
        }
        return ans;
    }
}
