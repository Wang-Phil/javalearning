package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 */
public class Leetcode2529 {
    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
    }

/*
    public static int maximumCount(int[] nums) {
        //方法1：直接遍历
        int pos = 0;
        int neg = 0;
        for(int x : nums){
            if(x > 0) pos++;
            if(x < 0) neg++;
        }
        return Math.max(pos,neg);
    }
 */
    public static int maximumCount(int[] nums) {
        //方法2：二分查找
        int neg = BinarySearch(nums, 0);
        int pos = nums.length - BinarySearch(nums,1);
        return Math.max(pos,neg);
    }

    public static int BinarySearch(int []nums, int x){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] < x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }


}
