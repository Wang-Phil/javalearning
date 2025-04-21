package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/23
 *@Time: 2:30
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？
 */

public class Leetcode62 {
    public static void main(String[] args) {

    }
    //不同路径
    public int uniquePaths(int m, int n) {
        //二维dp动态规划
        int dp[][]  = new int[m][n];
        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for(int i = 1; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
