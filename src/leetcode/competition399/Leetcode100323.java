package leetcode.competition399;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/26
 *@Time: 10:31
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。

如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。

返回 优质数对 的总数。
 */

public class Leetcode100323 {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[]{1,2,4,12}, new int[]{2,4}, 3));
    }
    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i = 0; i < n2; i++) {
            nums2[i] = nums2[i] * k;
        }

        int res = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if(nums1[i] % nums2[j] == 0){
                    res += 1;
                }
            }
        }
        return res;
    }
}
