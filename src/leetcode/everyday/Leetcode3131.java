package leetcode.everyday;

import java.util.Arrays;

/*给你两个长度相等的数组 nums1 和 nums2。

数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。

在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。

返回整数 x 。*/
public class Leetcode3131 {
    public static void main(String[] args) {

    }
    //找出与数组相加的整数
    public int min(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = Math.min(num, nums[i]);
        }
        return num;
    }

    public int addedInteger(int[] nums1, int[] nums2) {
        return min(nums2) - min(nums1);
    }
}
