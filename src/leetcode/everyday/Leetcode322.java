package leetcode.everyday;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class Leetcode322 {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < n; j++){
                if(((long)i + (long)coins[j]) <= (long) amount){
                    System.out.println(i+" "+ "coins "+ coins[j] + " 和："+ i + coins[j] +" "+ amount);
                    System.out.println((long)(i + coins[j]) <= (long) amount);
                    dp[i + coins[j]] = Math.min(dp[i]+1, dp[i + coins[j]] );
                }
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }

}
