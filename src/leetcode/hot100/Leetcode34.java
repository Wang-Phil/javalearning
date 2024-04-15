package leetcode.hot100;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int first = lower_bound(nums, target);
        System.out.println(first);
        if(nums.length == 0 || nums[first] != target) return new int[]{-1, -1};
        int end = lower_bound(nums, target+1);
        return new int[]{first, end - 1};
    }

    public static int lower_bound(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
