package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/5
 *@Time: 11:46
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */

import java.util.Arrays;
import java.util.HashMap;

public class leetcode205 {
    public static void main(String[] args) {

    }
    //同构字符串
    public boolean isIsomorphic(String s, String t) {
        //两个hash表
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if(s2t.containsKey(s1) && s2t.get(s1) != t1 || t2s.containsKey(t1) && t2s.get(t1) != s1){
                return false;
            }
            s2t.put(s1, t1);
            t2s.put(t1, s1);
        }
        return true;
    }
}
