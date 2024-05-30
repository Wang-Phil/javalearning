package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/30
 *@Time: 9:18
 * 给你一个仅由小写英文字母组成的字符串 s 。

如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。

返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。

子字符串 是字符串中的一个连续 非空 字符序列。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode2982 {
    public static void main(String[] args) {

    }
    //找出出现至少三次的最长特殊子字符串2，题目和2981的一模一样，就是数据集变大了
    public int maximumLength(String s) {
        char str[] = s.toCharArray();
        List<Integer> list[] = new ArrayList[26];
        Arrays.setAll(list, i-> new ArrayList<>());
        int cnt = 0;
        //统计数
        for (int i = 0; i < str.length; i++) {
            cnt++;
            if(i + 1 == str.length || str[i] != str[i+1]){
                list[str[i] - 'a'].add(cnt);
                cnt = 0;
            }
        }
        //找出最长
        int ans = 0;
        for(List<Integer> l : list){
            if(l.size() == 0) continue;
            l.sort(Collections.reverseOrder());
            l.add(0);
            l.add(0);
            ans = Math.max(ans, Math.max(l.get(0)-2 ,Math.max(Math.min(l.get(0)-1, l.get(1)),l.get(2))));
        }
        return ans == 0 ? -1 : ans;
    }
}
