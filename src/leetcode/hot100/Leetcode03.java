package leetcode.hot100;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class Leetcode03 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(new String("abba")));
    }
/*
    public static int lengthOfLongestSubstring(String s) {
        //滑动变长窗口
        int max_len = 0;
        int n = s.length();
        int width = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int len = 0, i = 0;
        while(i < n){
            int j = i;
            while(j < n && !hashSet.contains(s.charAt(j))){
                len++;
                hashSet.add(s.charAt((j)));
                j++;
            }
            i++;
            max_len = Math.max(len, max_len);
            len = 0;
            hashSet.clear();
        }
        return max_len;
    }

 */

    public static int lengthOfLongestSubstring(String s) {
        //滑动变长窗口
        int left = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i))+1);  //如果有重复的，就更新更大的左边界
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i  - left + 1);
        }
        return ans;
    }
}
