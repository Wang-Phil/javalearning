package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/17
 *@Time: 10:38
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */

public class Leetcode279 {
    public static void main(String[] args) {

    }
    //完全平法数
    //方法1：动态规划
    public int numSquares(int n) {
        //这个怎么动态规划？ dp[i] = dp[i -j*j] + 1
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    //方法2：数学,四平方定理，任意一个正整数都可以由四个平方数构成
    public int numSquares1(int n) {
        //判断为1，本身即是平方数
        if(isSquare(n)) return 1;

        //判断是否是4
        //如果n == 4^k * (8m + 7),只能被表示成四个数字
        int num = n;
        while(num % 4 == 0){
            num /= 4;
        }
        if(num % 8 == 7) return 4;

        //判断是否是2
        for(int i = 0; i * i < n; i++){
            if(isSquare(n - i * i)) return 2;
        }

        //就只能为3了
        return 3;

    }

    //判断是否是平方数
    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

}
