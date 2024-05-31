package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/29
 *@Time: 10:15
 * 给你一个仅由小写英文字母组成的字符串 s 。

如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。

返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。

子字符串 是字符串中的一个连续 非空 字符序列。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode2981 {
    public static void main(String[] args) {

    }
    //找出出现至少三次的最长特殊子字符串
    public int maximumLength(String s) {
        //分情况进行讨论：
        //首先将每个字母作为开头的时候，统计其所在字符的长度,然后逆序排序
        //然后如果a[0] == a[1]，就应该去a[0]-1,如果a[0]大于a[1]就应该取a[1],如果是三个数，就应该取a[2],如果是一个数就应该取a[0]-2
        char str[] = s.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<Integer>());
        int cnt = 0;
        for(int i = 0; i < str.length; i++) {
            cnt++;
            if(i+1 == str.length || str[i] != str[i+1]) {//一旦不相同了，就加入到group当中
                groups[str[i] - 'a'].add(cnt);
                cnt = 0;
            }
        }
        //对其进行逆序排序
        int ans = 0;
        for(List<Integer> group : groups) {
            if(group.size() == 0) continue;
            group.sort(Collections.reverseOrder());
            group.add(0);
            group.add(0);       //添加两个0，保证其在后序的情况中，不用再分情况进行讨论
            ans = Math.max(ans,Math.max(group.get(0)-2,Math.max(Math.min(group.get(0)-1, group.get(1)),group.get(2))));
        }
        return ans;
    }
}
