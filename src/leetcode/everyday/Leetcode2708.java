package leetcode.everyday;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/9/3
 * @Time: 10:53
 *
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​] 。
 * 请你返回老师创建的小组能得到的最大实力值为多少
 **/
public class Leetcode2708 {
    public static void main(String[] args) {
        System.out.println(maxStrength(new int[]{3,-1,-5,2,5,-9}));
    }

    public static long maxStrength(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1) return nums[0];
        if(nums.length == 2 && nums[0] < 0  && nums[1] >= 0) return nums[1];
        long max = 0;
        int i = 0;
        long start = 1;
        while(i < nums.length && nums[i] < 0){
            start *= nums[i++];
        }
        if(start < 0) start /= nums[i-1];
        max = start;
        if((i == 1 || i == 0)&& nums[nums.length - 1] == 0 ) return 0;
        for(;i < nums.length; i++){
            if(nums[i] > 0){
                max *= nums[i];
            }
        }
        return max;
    }
}
