package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/22
 *@Time: 10:09
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。

返回一个长度为 2 的列表 answer ：

answer[0] 是所有 没有 输掉任何比赛的玩家列表。
answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
两个列表中的值都应该按 递增 顺序返回。
 */

import java.util.*;

public class Leetcode2225 {
    public static void main(String[] args) {
        System.out.println(findWinners(new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}}));
    }
    //找出输掉零场或一场比赛的玩家
    public static List<List<Integer>> findWinners(int[][] matches) {
        //hash表+排序
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] match : matches) {//如果是winer，就将其置为0
            if(!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
            map.put(match[1],map.getOrDefault(match[1],0)+1);       //如果是loser，就+1
        }
        //当前的map存储的是一直赢，map存的是0，或者输的场次，输的场次就是map对应的value
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            if(cnt < 2){
                res.get(cnt).add(entry.getKey());
            }
        }
        //然后排序
        Collections.sort(res.get(0));
        Collections.sort(res.get(1));
        return res;
    }
}
