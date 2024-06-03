package leetcode.competition400;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/2
 *@Time: 11:09
 * 给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。
返回员工可工作且没有安排会议的天数。
注意：会议时间可能会有重叠。
 */

import java.util.Arrays;

public class Leetcode100311 {
    public static void main(String[] args) {
//        System.out.println(countDays(14,new int[][]{{6, 11}, {7, 13}, {8, 9}, {5, 8}, {3, 13}, {11, 13}, {1, 3}, {5, 10}, {8, 13}, {3, 9}}));
    }
    //无需开会的工作日
    public static int countDays(int days, int[][] meetings) {
        //思路：根据会议结束时间进行排序，如果时间超了，就不用统计了
        Arrays.sort(meetings, (a, b)->(a[0]-b[0]));
        int ans = 0;
        int minStart = meetings[0][0];
        int maxEnd = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if(maxEnd < meetings[i][0]) {//如果当前end，不在下一个区间内，就统计空闲的时间
                ans += meetings[i][0] - maxEnd - 1;
                maxEnd = meetings[i][1];
            }else{
                maxEnd = Math.max(meetings[i][1], maxEnd);
            }
            minStart = Math.min(minStart, meetings[i][0]);
        }
        ans += maxEnd == days ? 0 : (days - maxEnd);
        ans += minStart > 1 ? minStart - 1 : 0;
        return ans;
    }
}
