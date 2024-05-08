package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/8
 *@Time: 10:47
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
回文串
 。返回 s 所有可能的分割方案。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a"));
    }
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> list =    new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return ans;
    }
    public void backTracking(String s, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String str = s.substring(index, i + 1);
            list.add(str);
            if(isPalindrome(str)) {
                backTracking(s, i+1);
            }
            list.remove(list.size()-1);
        }
    }

    public static boolean isPalindrome(String s) {
        if(s == null   || s.length() <= 1) return true;
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
