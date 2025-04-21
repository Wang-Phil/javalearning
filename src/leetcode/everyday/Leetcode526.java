package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/26
 *@Time: 10:11
 * 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
perm[i] 能够被 i 整除
i 能够被 perm[i] 整除
给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
 */

import java.util.Arrays;

public class Leetcode526 {
    public static void main(String[] args) {

    }
    //优美的排列
    //采用记忆化搜索的方法求解
    public int countArrangement(int n) {
        //用二进制来表示集合，并用二进制来进行集合的运算
        int memo[] =  new int[1 << n];
        Arrays.fill(memo,-1);
        return dfs(0, n, memo);
    }
    private int dfs(int s, int n, int[] memo) {
        //s == (1 << n) - 1 判断是否所有元素都是在s中，如果是就是一个排列
        if(s == (1 << n) - 1) return 1;
        if(memo[s] != -1) return memo[s];       //记忆化搜索，这里表明之前已经计算过

        int res = 0;
        // i计算当前元素的个数，需要加1，因为起始下标是从1开始算的
        int i = Integer.bitCount(s) + 1;
        for(int j = 1; j <= n; j++) {
            //s集合中，是从0开始算的，所以这里与集合s的运算都要进行减一操作
            //s >> ((j - 1) & 1 这个是判断元素j是否在集合s中
            if((s >> (j - 1) & 1) == 0 && ( i % j == 0 || j % i == 0)) {
                //s | (1 << (j - 1)) 表示把j-1加入到集合s中
                res += dfs(s | (1 << (j - 1)), n, memo);
            }
        }
        memo[s] = res;      //实现记忆化
        return res;
    }
}
