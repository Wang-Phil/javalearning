package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/16
 *@Time: 21:49
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。请你计算以下两个数值：

answer1：使得 nums1[i] 在 nums2 中出现的下标 i 的数量。
answer2：使得 nums2[i] 在 nums1 中出现的下标 i 的数量。
返回 [answer1, answer2]。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode2956 {
    public static void main(String[] args) {

    }
    //找到两个数组中的公共元素
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<>();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
            if(set1.contains(nums2[i])){
                num1++;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if(set2.contains(nums1[i])){
                num2++;
            }
        }
        return new int[]{num1, num2};
    }
}
