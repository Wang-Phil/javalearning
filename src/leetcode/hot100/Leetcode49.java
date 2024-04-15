package leetcode.hot100;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class Leetcode49 {
    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strings));
    }
/*
    public static List<List<String>> groupAnagrams(String[] strs) {
        //方法一、排序
        Map<String ,ArrayList<String>> map = new HashMap<>();
        for(String str : strs){
            char []array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

 */
    public static List<List<String>> groupAnagrams(String[] strs) {
        //方法二、数组存储计数
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            int nums[] = new int[26];
            for (int i = 0; i < str.length(); i++) {
                nums[str.charAt(i) - 'a']++;
            }
            //个数不为0的字母，组成一串字符串
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if(nums[i] != 0){
                    stringBuffer.append((char)('a'+i));
                    stringBuffer.append(nums[i]);
                }
            }
            //转换成String，作为key传入map中
            String key = new String(stringBuffer);
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
