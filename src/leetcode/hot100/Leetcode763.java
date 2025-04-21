package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/16
 *@Time: 9:54
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。

注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。

返回一个表示每个字符串片段的长度的列表。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
    //划分字母区间
    public static List<Integer> partitionLabels(String s) {
        //步骤：先采用hash表统计，每个字符可以到达的最远距离，然后遍历字符串，维护一个end，作为当前字符串中字母出现的最远距离，一旦i等于end，说明已经到达了最远可以到达的地方，进行一次字母划分
        int hash[] = new int[27];
        List<Integer> list = new ArrayList<Integer>();
        int end = 0;
        int start = 0;
        //统计每个字母可以到达的最远距离
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a'] = i;
        }
        //然后遍历字符串
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, hash[s.charAt(i)-'a']);
            if(i == end){
                list.add(end - start +1);
                start = end + 1;
            }
        }
        return list;
    }
}
