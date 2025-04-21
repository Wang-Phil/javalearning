package leetcode.everyday;

import java.util.HashMap;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/10/11
 * @Time: 13:45
给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。

如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。

返回 优质数对 的总数。

 *
 **/

public class Leetcode3164 {
    //优质数对的总数
    public static void main(String[] args) {

    }

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //思路：遍历nums1中的每个因子，判断每个因子是否可以整除nums2
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] % k > 0) continue;

            int num = nums1[i] / k;
            for (int j = 1; j * j  <= num; j++){
                if(num % j > 0) continue;
                map.put(j, map.getOrDefault(j, 0) + 1);
                if(j * j < num){
                    map.put(num/j, map.getOrDefault(num/j, 0) + 1);
                }
            }
        }
        long ans = 0;
        for(int num : nums2){
            ans += map.getOrDefault(num, 0);
        }
        return ans;
    }

}
