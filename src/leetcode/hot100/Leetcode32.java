package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/22
 *@Time: 15:33
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */

public class Leetcode32 {
    public static void main(String[] args) {

    }
    //最长的有效括号
    public int longestValidParentheses(String s) {
        //动态规划
        int n = s.length();
        int dp[] = new int[n];
        int max = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = 2;
                    if(i - 2 >= 0){
                        dp[i] = dp[i-2] + 2;
                    }
                }else if (dp[i-1] > 0) {
                    if(i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(' ){
                        dp[i] = dp[i-1] + 2;
                        if(i - dp[i-1] -2 >= 0){
                            dp[i] = dp[i] + dp[i - dp[i-1] -2];
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
