package leetcode.competition404;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/30
 *@Time: 11:32
 * 给你一个整数数组 nums 和一个 正 整数 k 。
nums 的一个
子序列
 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ：
(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k
返回 nums 的 最长有效子序列 的长度。
 */

import java.util.Arrays;

public class Leetcode100358 {
    public static void main(String[] args) {
//    // 测试用例
//        System.out.println(maximumLength(new int[]{1, 2, 3, 4, 5}, 2)); // 输出：5
//        System.out.println(maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3)); // 输出：4
        System.out.println(maximumLength(new int[]{1, 7, 2, 8, 4, 6}, 5)); // 输出：2
//        System.out.println(maximumLength(new int[]{5, 10, 15, 20}, 5)); // 输出：4
//        System.out.println(maximumLength(new int[]{6, 12, 18, 24}, 6)); // 输出：4
    }
    public static int maximumLength(int[] nums, int k) {
        if (nums.length <= 2) return nums.length;
        int n = nums.length;
        int dp[][] = new int[k][k];
        int ans = 0;
        for(int num : nums){
            int x = num % k;
            for (int y = 0; y < k; y++) {
                dp[y][x] = dp[x][y] + 1;
                ans = Math.max(ans, dp[y][x]);
            }

        }
        return ans;
    }


}
