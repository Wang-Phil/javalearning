package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/18
 *@Time: 15:15
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。
 */

import java.util.Arrays;

public class Leetcode322 {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        //dp动态规划
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if((long)i + (long)coins[j] <= amount){
                    dp[i+coins[j]] = Math.min(dp[i]+1, dp[i+coins[j]]);
                }
            }
        }
        return dp[amount];
    }
}
