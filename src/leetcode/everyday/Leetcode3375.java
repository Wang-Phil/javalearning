package leetcode.everyday;

import java.util.Arrays;

public class Leetcode3375 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{9,7,5,3},1));
    }

    public static int minOperations(int[] nums, int k) {
        //思路是排序+统计不同元素个数
        Arrays.sort(nums);
        int min = nums[0];
        int cnt = 1;
        if(min < k) return -1;
        else if(min == k) {cnt--;}
        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i+1] ){
                cnt++;
            }
        }
        return cnt;
    }
}
