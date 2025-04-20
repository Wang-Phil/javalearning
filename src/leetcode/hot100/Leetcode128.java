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
        // 思路，先全部放到hashset当中，再判断前一个数字是否存在
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 1;
        int cnt = 1;
        // 细节二：遍历集合
        for(int num : set){
            // 细节三，看num-1是否存在
            if(set.contains(num-1)){
                continue;
            }
            cnt = num;
            while (set.contains(cnt+1)){
                cnt++;
            }
            max = Math.max(max,cnt - num + 1);
        }
        return max;
    }
}
