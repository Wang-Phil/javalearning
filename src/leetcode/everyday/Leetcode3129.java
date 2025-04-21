package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/8/5
 *@Time: 9:52
给你 3 个正整数 zero ，one 和 limit 。

一个
二进制数组
 arr 如果满足以下条件，那么我们称它是 稳定的 ：

0 在 arr 中出现次数 恰好 为 zero 。
1 在 arr 中出现次数 恰好 为 one 。
arr 中每个长度超过 limit 的
子数组
 都 同时 包含 0 和 1 。
请你返回 稳定 二进制数组的 总 数目。

由于答案可能很大，将它对 109 + 7 取余 后返回。
 */

import java.util.Arrays;

public class Leetcode3129 {
    public static void main(String[] args) {

    }
    //不含连续1的非负整数
    private static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] memo = new int[zero + 1][one + 1][2];
        for (int[][] m : memo) {
            for (int[] m2 : m) {
                Arrays.fill(m2, -1); // -1 表示没有计算过
            }
        }
        return (dfs(zero, one, 0, limit, memo) + dfs(zero, one, 1, limit, memo)) % MOD;
    }

    private int dfs(int i, int j, int k, int limit, int[][][] memo) {
        if (i == 0) { // 递归边界
            return k == 1 && j <= limit ? 1 : 0;
        }
        if (j == 0) { // 递归边界
            return k == 0 && i <= limit ? 1 : 0;
        }
        if (memo[i][j][k] != -1) { // 之前计算过
            return memo[i][j][k];
        }
        if (k == 0) {
            // + MOD 保证答案非负
            memo[i][j][k] = (int) (((long) dfs(i - 1, j, 0, limit, memo) + dfs(i - 1, j, 1, limit, memo) +
                    (i > limit ? MOD - dfs(i - limit - 1, j, 1, limit, memo) : 0)) % MOD);
        } else {
            memo[i][j][k] = (int) (((long) dfs(i, j - 1, 0, limit, memo) + dfs(i, j - 1, 1, limit, memo) +
                    (j > limit ? MOD - dfs(i, j - limit - 1, 0, limit, memo) : 0)) % MOD);
        }
        return memo[i][j][k];
    }
}
