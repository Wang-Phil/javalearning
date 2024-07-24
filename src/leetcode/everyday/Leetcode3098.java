package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/23
 *@Time: 9:35
 * 给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。
一个 子序列
 的 能量 定义为子序列中 任意 两个元素的差值绝对值的 最小值 。

请你返回 nums 中长度 等于 k 的 所有 子序列的 能量和 。

由于答案可能会很大，将答案对 109 + 7 取余 后返回。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode3098 {
    public static void main(String[] args) {

    }
    //求出所有子序列的能量和
    private Map<Long, Integer> f = new HashMap<>();
    private final int mod = (int) 1e9 + 7;
    private int[] nums;

    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        return dfs(0, nums.length, k, Integer.MAX_VALUE);
    }

    private int dfs(int i, int j, int k, int mi) {
        if (i >= nums.length) {
            return k == 0 ? mi : 0;
        }
        if (nums.length - i < k) {
            return 0;
        }
        long key = (1L * mi) << 18 | (i << 12) | (j << 6) | k;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int ans = dfs(i + 1, j, k, mi);
        if (j == nums.length) {
            ans += dfs(i + 1, i, k - 1, mi);
        } else {
            ans += dfs(i + 1, i, k - 1, Math.min(mi, nums[i] - nums[j]));
        }
        ans %= mod;
        f.put(key, ans);
        return ans;
    }
}
