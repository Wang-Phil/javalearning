package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/26
 *@Time: 17:37
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
 */

import java.util.Arrays;

public class Leetcode72 {
    public static void main(String[] args) {

    }
    //编辑距离
    private char[] s, t;
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        //第一种做法，递归搜索+保存计算机结果=记忆化搜索
        s = word1.toCharArray();
        t = word2.toCharArray();
        int n = s.length, m = t.length;
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n-1, m-1);
    }

    private int dfs(int i, int j) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(memo[i][j] != -1) return memo[i][j];
        if(s[i] == t[j]) return memo[i][j] = dfs(i - 1, j- 1);
        return memo[i][j] = Math.min(Math.min(dfs(i-1, j), dfs(i, j-1)),dfs(i -1, j-1)) + 1;
    }

    //动态规划方式求解
    class Solution {
        public int minDistance(String text1, String text2) {
            char[] s = text1.toCharArray(), t = text2.toCharArray();
            int n = s.length, m = t.length;
            int[][] f = new int[n + 1][m + 1];
            for (int j = 1; j <= m; ++j) f[0][j] = j;
            for (int i = 0; i < n; ++i) {
                f[i + 1][0] = i + 1;
                for (int j = 0; j < m; ++j)
                    f[i + 1][j + 1] = s[i] == t[j] ? f[i][j] :
                            Math.min(Math.min(f[i][j + 1], f[i + 1][j]), f[i][j]) + 1;
            }
            return f[n][m];
        }
    }
}
