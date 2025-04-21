package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/1
 *@Time: 15:29
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */

public class Leetcode10 {
    public static void main(String[] args) {

    }
    //正则表达式匹配
    public boolean isMatch(String s, String p) {
        //动态规划
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        //初始化首行
        for (int j = 2; j < n; j+=2) {
            dp[0][j] = dp[0][j-2] && p.charAt(j-1) == '*';
        }
        //然后是正常的动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j-1) == '*') {
                    if(dp[i][j-2]) dp[i][j] = true;
                    else if(dp[i-1][j] && s.charAt(i-1) == p.charAt(j-2)) dp[i][j] = true;
                    else if(dp[i-1][j] && p.charAt(j-2) == '.') dp[i][j] = true;
                }else{
                    if(dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1)) dp[i][j] = true;
                    else if(dp[i-1][j-1] && p.charAt(j-1) == '.') dp[i][j] = true;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
