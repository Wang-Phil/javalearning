package leetcode.hot100;

import java.util.Arrays;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Leetcode283 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            nums[i] = 0;
            if(temp != 0) nums[k++] = temp;
        }
    }
}
