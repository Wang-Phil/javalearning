package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/15
 *@Time: 0:55
 * 你有一台电脑，它可以 同时 运行无数个任务。给你一个二维整数数组 tasks ，其中 tasks[i] = [starti, endi, durationi] 表示第 i 个任务需要在 闭区间 时间段 [starti, endi] 内运行 durationi 个整数时间点（但不需要连续）。

当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。

请你返回完成所有任务的情况下，电脑最少需要运行多少秒。
 */

import java.util.Arrays;

public class Leetcode2589 {
    public static void main(String[] args) {
        System.out.println();
    }
    //完成所有任务的最少时间
    public int findMinimumTime(int[][] tasks) {
        //排序+贪心，优先使用后面的点
        Arrays.sort(tasks, (a,b)->a[1]-b[1]);           //按照结束时间进行排序
        int maxTime = tasks[tasks.length-1][1];         //最后的结束时间
        boolean used[] = new boolean[maxTime+1];        //判断这个时间点是否使用过的数组
        int ans = 0;                                    //统计已经使用的时间
        for(int task[] : tasks){
            int start = task[0];
            int end = task[1];
            int time = task[2];
            for(int i=start; i<=end; i++){
                if(used[i]){                            //如果使用过
                    time--;                             //优先使用已经在运行的点
                }
            }
            for(int i = end; time > 0; i--){           //然后再使用最后面的点
                if(!used[i]){
                    used[i] = true;                    //标记为使用过
                    time--;                            //run一次，时间减1
                    ans++;                             //统计时间+1
                }
            }
        }
        return ans;
    }

}
