package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 12:42
 */

import java.util.Arrays;

public class Leetcode238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
/*    public static int[] productExceptSelf(int[] nums) {
        //除自身以外数组的乘积，还不能用除法
        //通过两个数组来存储，除了当前下标下左半部分，和右半部分的乘积
        //时间复杂度为O(n)，空间复杂度为O(n)
        int n = nums.length;
        int preSum[] = new int[n];
        int nextSum[] = new int[n];
        preSum[0] = 1;
        nextSum[n - 1] = 1;
        //先计算左半部分的乘积
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] * nums[i - 1];
        }
        //然后计算右半部分的乘积
        for (int i = n - 2; i >= 0; i--) {
            nextSum[i] = nextSum[i + 1] * nums[i + 1];
        }
        //最后计算整个的乘积
        for (int i = 0; i < n; i++) {
            nums[i] = preSum[i] * nextSum[i];
        }
        return nums;
    }*/

    //降低空间复杂度，降为O(1)
    public static int[] productExceptSelf(int[] nums) {
        //除自身以外数组的乘积，还不能用除法
        //通过两个数组来存储，除了当前下标下左半部分，和右半部分的乘积
        //时间复杂度为O(n)，空间复杂度为O(1)
        int n = nums.length;
        int Sum[] = new int[n];
        Sum[0] = 1;
        //先计算左半部分的乘积
        for (int i = 1; i < n; i++) {
            Sum[i] = Sum[i - 1] * nums[i - 1];
        }
        //然后计算右半部分的乘积
        int temp = 1;
        for (int i = n - 2; i >= 0; i--) {
            temp *= nums[i+1];
            Sum[i] = Sum[i] * temp;
        }
        return Sum;
    }
}
