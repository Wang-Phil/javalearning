package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class Leetcode518 {
    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,4}));
    }
    public static int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        int n = coins.length;
        dp[0] = 1;
        //动态规划求解，dp[i] = 求和，当i-coins[j]不为0的时候
        //外层循环是coin的时候，不会造成重复计算
        //如果外层循环是amount的话，会对coin造成重复计算，外层循环是amount求的是排列数
        //内层循环是求的组合数
        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                dp[j] += dp[j-coin];
            }
        }
        return dp[amount];
    }
}
