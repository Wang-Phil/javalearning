package leetcode.hot100;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Leetcode128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int longestConsecutive(int[] nums) {
        //hash表
        if (nums.length == 0) return 0;
        int max = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int x : nums) {
            if (!set.contains(x - 1)) {
                int currentNum = x;
                int maxlen = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    maxlen++;
                }
                max = Math.max(max, maxlen);
            }
        }
        return max;
    }
}
