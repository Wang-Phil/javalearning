package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/22
 *@Time: 12:40
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */

public class Leetcode41 {
    //缺失的第一个正数，方法进行原地hash
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
    }

/*    public static int firstMissingPositive(int[] nums) {
        //进行原地hash
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //不满足条件就交换
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        //如果不符合，就说明是第一个未出现的数字
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }*/
    public static int firstMissingPositive(int[] nums) {
        //分情况解决
        //1、如果是负数，将其转变为n+1
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0) nums[i] = n+1;
        }
        //2、如果是<=length的数，就将其对应位置置为负数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //3、剩下的第一个非负数就是要求的数字
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) return i+1;
        }
        return n+1;
    }
}
