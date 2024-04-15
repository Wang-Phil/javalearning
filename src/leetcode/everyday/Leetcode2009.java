package leetcode.everyday;

import java.util.Arrays;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
 * 如果 nums 满足以下条件，那么它是 连续的 ：
 * nums 中所有元素都是 互不相同 的。
 * nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
 * 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
 * 请你返回使 nums 连续 的 最少 操作次数。
 */
public class Leetcode2009 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,10,100,1000}));
    }

    public static int minOperations(int[] nums) {
        //思路：排序+去重+滑动窗口，采用逆向思维，求多少个数字是可以不用变的。
        int ans = 1;
        int n = nums.length;
        //排序
        Arrays.sort(nums);
        int j = 0;
        //原地去重
        for(int i = 0; i < n; i++){
            if(i==0 || nums[i] != nums[i-1]){
                nums[j++] = nums[i];
            }
        }
        //滑动窗口
        int left = 0;
        for(int i = 0; i < j; i++){
            if(nums[left] < nums[i] - n + 1){
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return n - ans;
    }
}
