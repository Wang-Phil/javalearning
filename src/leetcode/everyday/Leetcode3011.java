package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/13
 *@Time: 9:20
 * 给你一个下标从 0 开始且全是 正 整数的数组 nums 。

一次 操作 中，如果两个 相邻 元素在二进制下数位为 1 的数目 相同 ，那么你可以将这两个元素交换。你可以执行这个操作 任意次 （也可以 0 次）。

如果你可以使数组变有序，请你返回 true ，否则返回 false 。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode3011 {
    public static void main(String[] args) {

    }
    //判断一个数组是否可以变为有序
    public boolean canSortArray(int[] nums) {
        //分组循环
        int n = nums.length;
        int preMax = 0;
        for(int i = 0; i < n;){
            int start = i;
            int max = 0;
            int cnt = Integer.bitCount(nums[i]);
            while(i < n && cnt == Integer.bitCount(nums[i])){
                if(preMax > nums[i]){
                    return false;
                }
                max = Math.max(max, nums[i]);
                i++;
            }
            preMax = max;
        }
        return true;
    }
}
