package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/1
 *@Time: 16:20
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。

丑数 就是质因子只包含 2、3 和 5 的正整数。
 */

public class Leetcode264 {
    public static void main(String[] args) {}
    //丑数
    public int nthUglyNumber(int n) {
        //动态规划
        int dp[] = new int[n+1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        int num2 = 2, num3 = 3, num5 = 5;
        for (int i = 2; i <= n; i++) {
            num2 = dp[p2] * 2;
            num3 = dp[p3] * 3;
            num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if(dp[i] == num2) p2++;
            if(dp[i] == num3) p3++;
            if(dp[i] == num5) p5++;
        }
        return dp[n];
    }
}
