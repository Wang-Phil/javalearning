package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/3
 *@Time: 20:07
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class Leetcode70 {
    public static void main(String[] args) {

    }
/*    //动态规划，爬楼梯
    public int climbStairs(int n) {
        int sum = 0;
        //首先是数组进行模拟
        int dp[]= new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }*/

    public int climbStairs(int n) {
        //然后是空间复杂度的优化
        int sum = 0;
        int first = 1;
        int second = 1;
        for(int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

}
