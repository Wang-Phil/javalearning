package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/9
 *@Time: 9:54
 * 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。

求所能获得硬币的最大数量。
 */

import java.util.Arrays;

public class Leetcode312 {
    //分治的思想
    public static void main(String[] args) {

    }
    //逆向思维，从0个气球往后加，到最后面可以有多少个气球
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n+2];
        ans[0] = 1;
        ans[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            ans[i] = nums[i-1];
        }
        //记忆化的数组
        int cache[][] = new int[n+2][n+2];
        for(int row[] : cache){
            Arrays.fill(row, -1);
        }

        //递归
        return dfs(cache, ans, 0, n+1);
    }

    //递归搜索
    private int dfs(int[][] cache, int[] ans, int i, int j) {
        //区间超过了，不存在这个值，就跳出循环
        if(i >= j-1) return 0;
        //如果记忆化搜存在就返回记忆化，减少时间复杂度
        if(cache[i][j] != -1) return cache[i][j];
        int res = 0;
        //遍历(left,right)区间，每得到一个乘积，就将其分为两部分
        for(int left = i+1; left < j; left++) {
            int total  = ans[i]*  ans[left] * ans[j];
            total += dfs(cache, ans, i, left) + dfs(cache, ans, left, j);
            res = Math.max(res, total);
        }
        cache[i][j] = res;
        return res;
    }
}
