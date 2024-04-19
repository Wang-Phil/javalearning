package leetcode.hot100;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/19
 *Time: 下午2:16
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    public static void main(String[] args) {
        int ans[][] = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(Arrays.deepToString(ans));
    }

    public static int[][] merge(int[][] intervals) {
        //合并所有的重叠区间，按照区间的所有左端点进行排序
/*        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });*/
        //简写排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= end) {//如果区间重叠了，就继续找
                end = Math.max(end, interval[1]);
            } else{
                //如果不重叠，就把不重叠的区域加入到res当中
                res.add(new int[]{start, end});
                //同时，更新start和end，接下来继续找
                start = interval[0];
                end = interval[1];
            }
        }
        //剩下的最后一个没有加入到目标数组中
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
