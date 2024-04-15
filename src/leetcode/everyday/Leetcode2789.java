package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2789 {
    public static void main(String[] args) {
        int nums[] = {2,3,7,9,3};
        System.out.println(maxArrayValue(nums));;
    }

    public static long maxArrayValue(int[] nums) {
        //从后往前遍历，就可以，然后维护一个最大值
        int n = nums.length;
        long ans = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            ans = nums[i] <= ans ? nums[i] + ans : nums[i];
        }
        return ans;
    }
}
