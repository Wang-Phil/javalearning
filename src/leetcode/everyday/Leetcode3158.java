package leetcode.everyday;

import java.util.HashMap;
import java.util.HashSet;

/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/10/12
 *@Time: 11:23
 * 给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。

请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
 */
public class Leetcode3158 {
    public static void main(String[] args) {

    }
    //求出出现两次数字的XOR值
    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                ans ^= nums[i];
            }
            set.add(nums[i]);
        }
        return ans;
    }


}
