package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/18
 *@Time: 15:45
 */

import java.util.Arrays;

public class Leetcode724 {
    public static void main(String[] args) {

    }
    //寻找数组的中心下标
    public int pivotIndex(int[] nums) {
        //先求和
        int sumLeft = 0, sumRight = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            sumRight -= nums[i];
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }
}
