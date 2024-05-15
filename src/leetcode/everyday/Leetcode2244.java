package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/14
 *@Time: 11:41
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 */

import java.util.HashMap;

public class Leetcode2244 {
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
    }
    //完成任务的最小轮数
    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < tasks.length; i++) {//先统计
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int res = 0;
        for (int value : map.values()) {//只能完成两个或者三个任务
            if(value == 1) return -1;
            res += (value + 2)/3;       //3*k，可以被三整除，  3*k+1 == 3*k` + 4 = 用k`次3，两次2,也就是 （c-4)/3 + 2 == (2+c)/3   3*k+2 == (c-2)/3+1 = (c+1)/3,最后合并成 (c+2)/2
        }
        return res;
    }

}
