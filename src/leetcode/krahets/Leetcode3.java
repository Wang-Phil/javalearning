package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/10
 *@Time: 20:56
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
子串
 的长度。
 */

import java.util.HashMap;
import java.util.Map;

public class Leetcode3 {
    public static void main(String[] args) {

    }
    //无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        //双指针解法
        int n = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                //如果重复，需要更新最大的左边界
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
