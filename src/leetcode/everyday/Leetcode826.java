package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/17
 *@Time: 9:46
 * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
 */

import java.util.Arrays;

public class Leetcode826 {
    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{23,30,35,35,43,46,47,81,83,98},new int[]{8,11,11,20,33,37,60,72,87,95},new int[]{95,46,47,97,11,35,99,56,41,92}));
    }
    //安排工作的最大收益
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //暴力思路，根据每个工人的劳动强度，在困难程度小于这个工人的劳动能力的时候，选择收益最大的一个
        int n = difficulty.length;
        int m = worker.length;
        int [][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = difficulty[i];
            nums[i][1] = profit[i];
        }
        Arrays.sort(nums,(a,b)->a[0]-b[0]);     //根据劳动强度进行排序
        Arrays.sort(worker);
        int maxProfit = 0;
        int curProfit = 0;                      //当前的最大收益
        int j = 0;
        for (int w : worker) {
            while(j < n && nums[j][0] <= w) {
                curProfit = Math.max(curProfit, nums[j][1]);
                j++;
            }
            maxProfit += curProfit;
        }
        return maxProfit;
    }
}
