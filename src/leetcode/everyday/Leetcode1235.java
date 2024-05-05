package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/4
 *@Time: 11:12
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
注意，时间上出现重叠的 2 份工作不能同时进行。
如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 */

import java.util.Arrays;

public class Leetcode1235 {
    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));
    }
    //规划兼职工作
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int jobs[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs,(a,b)->a[1]-b[1]);     //按照结束的时间进行排序
        //动态规划，申明dp数组
        int dp[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            int j = lower_bound(jobs, i, jobs[i][0]);
            dp[i+1] = Math.max(dp[i], dp[j+1] + jobs[i][2]);
        }
        return dp[n];
    }

    public static int lower_bound(int jobs[][], int endtime, int target){
        int left = -1;
        while(left + 1 < endtime){
            int  mid = left + (endtime - left)/2;
            if(jobs[mid][1] <= target){
                left = mid;
            }else{
                endtime = mid;
            }
        }
        return left;
    }
}
