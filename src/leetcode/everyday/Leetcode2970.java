package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/10
 *@Time: 10:03
 * 给你一个下标从 0 开始的 正 整数数组 nums 。

如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。比方说，[5, 3, 4, 6, 7] 中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。

请你返回 nums 中 移除递增 子数组的总数目。

注意 ，剩余元素为空的数组也视为是递增的。

子数组 指的是一个数组中一段连续的元素序列。
 */

public class Leetcode2970 {
    public static void main(String[] args) {

    }

    //统计移除递增子数组的数目
    public int incremovableSubarrayCount(int[] nums) {
        //前后缀
        int n = nums.length;
        int i = 0;
        while (i < n-1 && nums[i] < nums[i+1]){
            i++;
        }
        if (i == n-1){
            return n * (n+1)/2;
        }

        int ans = i+2;      //不保留后缀
        //保留后缀
        for(int j = n - 1; j == n - 1 || nums[j] < nums[j+1]; j--){
            while(i >= 0 && nums[i] >= nums[j]){
                i--;
            }
            ans += i+2;
        }
        return ans;
    }
}
