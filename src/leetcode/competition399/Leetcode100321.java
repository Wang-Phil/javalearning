package leetcode.competition399;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/26
 *@Time: 10:45
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。

如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。

返回 优质数对 的总数。
 */

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode100321 {
    public static void main(String[] args) {
//        System.out.println(lowerBound(new int[]{1,3,4}, 3));
        System.out.println(numberOfPairs(new int[]{1,2}, new int[]{2,3}, 2));
    }
    public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
        //枚举因子
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if(num % k > 0){
                continue;
            }
            num = num / k;
            for(int i = 1; i * i < num; i++){
                if(num % i > 0){
                    continue;
                }
                map.put(i, map.getOrDefault(i, 0) + 1);
                if(i * i < num){
                    map.put(num / i, map.getOrDefault(num / i, 0) + 1);
                }
            }
        }
        for(int num : nums2){
            res += map.getOrDefault(num, 0);
        }
        return res;
    }
}
