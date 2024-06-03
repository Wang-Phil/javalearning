package leetcode.competition400;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/2
 *@Time: 11:32
 * 给你一个字符串 s 。它可能包含任意数量的 '*' 字符。你的任务是删除所有的 '*' 字符。

当字符串还存在至少一个 '*' 字符时，你可以执行以下操作：

删除最左边的 '*' 字符，同时删除该星号字符左边一个字典序 最小 的字符。如果有多个字典序最小的字符，你可以删除它们中的任意一个。
请你返回删除所有 '*' 字符以后，剩余字符连接而成的
字典序最小的字符串。
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Leetcode100322 {
    public static void main(String[] args) {
        System.out.println(clearStars("abaa*c*b*d*a*"));
    }
    //删除星号以后字典序最小的字符串
    public static String clearStars(String s) {
        //思路：在遍历的过程中进行删除
        PriorityQueue<Integer>[] pq = new PriorityQueue[26];
        HashSet<Integer> set = new HashSet<>();
        // 初始化数组中的每个优先队列为最大堆
        for (int i = 0; i < pq.length; i++) {
            pq[i] = new PriorityQueue<>((a, b) -> b - a);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '*') {
                for(int j = 0; j < 26; j++){
                    if(pq[j].size() == 0){continue;}
                    set.add(pq[j].poll());
                    break;
                }
            }else{
                pq[chars[i]-'a'].add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(set.contains(i) || chars[i] == '*'){
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
