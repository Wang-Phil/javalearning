package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/5
 *@Time: 11:33
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */

public class Leetcode242 {
    public static void main(String[] args) {

    }
    //有效的字母异位词
    public boolean isAnagram(String s, String t) {
        //hash表
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        for(int i=0;i<schar.length;i++){
            arr[schar[i]-'a']++;
            arr[tchar[i]-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
