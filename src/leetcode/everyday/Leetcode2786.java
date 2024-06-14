package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/14
 *@Time: 15:27
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。

你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：

如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
对于你访问的位置 i ，你可以获得分数 nums[i] 。
如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
请你返回你能得到的 最大 得分之和。

注意 ，你一开始的分数为 nums[0] 。
 */

import java.util.Arrays;

public class Leetcode2786 {
    public static void main(String[] args) {

    }
    //访问数组中的位置使分数最大
    public long maxScore(int[] nums, int x) {
        //动态规划
        //保存当前元素是奇数的时候的最大值和当前元素是偶数的时候的最大值
        long dp[] = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        long ans = nums[0];
        dp[nums[0] % 2] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int dic = nums[i] % 2;
            long cur = Math.max(dp[dic] + nums[i], dp[1-dic] - x + nums[i]);
            ans = Math.max(ans, cur);
            dp[dic] = Math.max(dp[dic], cur);
        }
        return ans;
    }

    //灵神的思路，记忆化搜索
    public long maxScore2(int[] nums, int x) {
        int n = nums.length;
        long memo[][] = new long[n][2];
        for(long row[] : memo){
            Arrays.fill(row, -1);
        }
        return dfs(0, nums[0] % 2, nums, x, memo);
    }

    private long dfs(int i, int j, int[] nums, int x, long[][] memo){
        if(i ==  nums.length) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        //不满足奇偶性相同
        if(nums[i] % 2 != j){
            return memo[i][j] = dfs(i+1, j, nums, x, memo);
        }
        //满足第二种情况
        long res1 = dfs(i+1, j, nums, x, memo);
        long res2 = dfs(i+1, j ^ 1, nums, x, memo);
        return memo[i][j] = Math.max(res1, res2 - x) + nums[i];
    }
}
