package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class Leetcode438 {
    public static void main(String[] args) {
        System.out.println(String.valueOf(findAnagrams("cbaebabacd","abc")));
    }

 /*   public static List<Integer> findAnagrams(String s, String p) {
        //暴力解法，对字符串进行截取，然后进行排序，再采用Arrays的数组equals方法进行判断两个子串是否相等。
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        if(s.length() <p.length()){
            return list;
        }
        char p_chars[] = p.toCharArray();
        Arrays.sort(p_chars);
        for(int i = 0; i < s.length() - p.length() + 1; i++){
            char s_chars[] = s.substring(i, i+p.length()).toCharArray();
            Arrays.sort(s_chars);
            if(Arrays.equals(s_chars, p_chars)){
                list.add(i);
            }
        }
        return list;
    }*/

    /*public static List<Integer> findAnagrams(String s, String p) {
        //最主要的两种方式，一种是排序后使用arrays的equals方法进行比较，另外一个就是采用hash表进行判断
        //这里的话，是维护了两个hash表，可以改进只进行维护一个hash表
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        if(s.length() <p.length()){
            return list;
        }
        int p_hash[] = new int[26];
        int s_hash[] = new int[26];
        for(int i = 0; i < p.length(); i++){
            p_hash[p.charAt(i)-'a']++;
            s_hash[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(p_hash, s_hash)){
            list.add(0);
        }

        for(int i = 0; i < s.length() - p.length(); i++){
            --s_hash[s.charAt(i)-'a'];
            ++s_hash[s.charAt(i+p.length())-'a'];
            if(Arrays.equals(p_hash, s_hash)){
                list.add(i+1);
            }
        }
        return list;
    }*/

    public static List<Integer> findAnagrams(String s, String p) {
        //这里的话，是维护了两个hash表，可以改进只进行维护一个hash表
        //同时，如何判断两个字符串刚好相等的情况是，在出现的元素都相同的情况下，维护的窗口长度刚好等于p的长度
        List<Integer> list = new ArrayList<>();
        int s_len = s.length();
        int p_len = p.length();
        if(s_len < p_len){
            return list;
        }
        int hash[] = new int[26];
        for(int i = 0; i < p.length(); i++){
            hash[p.charAt(i)-'a']++;
        }

        for (int i = 0, left = 0; i < s_len; i++) {
            --hash[s.charAt(i)-'a'];
            while(hash[s.charAt(i)-'a'] < 0){
                ++hash[s.charAt(left)-'a'];
                left++;
            }
            if(i - left + 1 == p_len){
                list.add(left);
            }
        }
        return list;
    }
}
