package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/26
 *@Time: 17:31\
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

import java.util.Arrays;

public class Leetcode169 {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        //摩尔投票
        int x = nums[0];
        int count = 0;
        for(int num : nums){
            if(count == 0){
                x = num;
            }
            count += x == num ? 1 : -1;
        }
        return x;
    }
}
