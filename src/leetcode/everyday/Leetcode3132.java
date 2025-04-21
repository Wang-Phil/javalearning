package leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;

/**
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/8/9
 *@Time: 16:38
 **/

/*
给你两个整数数组 nums1 和 nums2。

从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。

执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。

返回能够实现数组相等的 最小 整数 x 。
*/

public class Leetcode3132 {
    public static void main(String[] args) {

    }
    //找出与数组相加的整数
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        //相比于3131多了两个不相关的数字，数组长度大于等于3
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i > 0; i--) {
            int x = nums2[0] - nums1[i];        //遍历x，因为只有两个元素不同，最小的元素一定在前三个当中，遍历最小的元素
            int j = 0;
            for(int k = i; k < nums1.length ; k++ ) {
                if(nums2[j] == nums1[k] + x && ++j == nums2.length){
                    return x;
                }
            }
        }
        //题目保证存在答案
        return nums2[0] - nums1[0];
    }
}

