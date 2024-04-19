package leetcode.hot100;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/19
 *Time: 下午2:38
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */

import java.util.Arrays;

public class Leetcode189 {
    public static void main(String[] args) {
        rotate(new int[]{-1,-100,3,99}, 2);
    }
    //向右轮转数组，至少三种方法解决
    /*//第一种解法：直接下标右移之后创建一个新的数组当中去，然后再给nums重新赋值
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[(i+k)%n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
        System.out.println(Arrays.toString(nums));
    }*/

/*    //第二种解法：数组翻转
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        System.out.println(Arrays.toString(nums));

    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }*/

    //第三种解法，原地赋值，空间复杂度为O(1)
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int cnt = gcd(k, n);
        for (int i = 0; i < cnt; i++) {
            int cur = i;
            int preNum = nums[cur];
            do{
                int next = (cur + k) % n;
                int temp = nums[next];
                nums[next] = preNum;
                preNum = temp;
                cur = next;
            }while(i != cur);

        }
        System.out.println(Arrays.toString(nums));
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
