package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/26
 *@Time: 10:01
 * 给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：
对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] == 0 。
请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。
 */

import java.util.Arrays;

public class Leetcode2741 {
    public static void main(String[] args) {

    }
    //特别的排列
    public int specialPerm(int[] nums) {
        //状态压缩dp，感觉题解都看不太懂，先赶紧完成了再说吧
        int n = nums.length;
        int u = (1 << n) - 1;
        long memo[][] = new long[u][n];
        for(long[] row : memo){
            Arrays.fill(row, -1);
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += dfs(u ^ (1 << i), i, nums, memo);
        }
        return (int)(ans % 1_000_000_007);
    }

    private long   dfs(int s, int i, int[] nums, long[][] memo){
        if(s == 0) return 1;
        if(memo[s][i] != -1) return memo[s][i];
        long ans = 0;
        for(int j = 0; j < nums.length; j++){
            if((s >> j & 1) > 0 && (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0)){
                ans += dfs(s ^ (1 << j), j, nums, memo);
            }
        }
        return memo[s][i] = ans;
    }
}
