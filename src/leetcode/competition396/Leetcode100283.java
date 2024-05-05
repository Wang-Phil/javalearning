package leetcode.competition396;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/5
 *@Time: 11:40
 */

import java.util.HashMap;
import java.util.Map;

public class Leetcode100283 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.minAnagramLength("cdef"));
    }
}
class Solution3 {
    public int  minAnagramLength(String s) {
        int n = s.length();

        // 遍历字符串s的因子
        for (int len = 1; len <= n; len++) {
            // 如果len是s的因子且满足条件，返回len作为最小可能长度
            if (n % len == 0 && isPossible(s, len)) {
                return len;
            }
        }

        return n;
    }

    // 判断是否满足条件
    private boolean isPossible(String s, int len) {
        int n = s.length();

        // 使用HashSet来存储字符
        HashMap<Character, Integer> map1 = new HashMap<>();
        String sub = s.substring(0, len);
        for (char c : sub.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        // 遍历字符串s，检查连续子字符串是否满足条件
        for (int i = len; i < n; i += len) {
            HashMap<Character, Integer> map2 = new HashMap<>();
            sub = s.substring(i, i + len);
            // 检查连续子字符串中的字符是否重复
            for (char c : sub.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }
            if(!compareHashMaps(map1,map2)){
                return false;
            }
        }
        return true;
    }

    public boolean compareHashMaps(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        // 比较HashMap的大小
        if (map1.size() != map2.size()) {
            return false;
        }

        // 遍历map1中的键值对，逐个在map2中进行比较
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            // 在map2中查找对应的键
            if (!map2.containsKey(key)) {
                return false;
            }

            // 检查对应的键的值是否相等
            if (!map2.get(key).equals(value)) {
                return false;
            }
        }
        return true;
    }
}
