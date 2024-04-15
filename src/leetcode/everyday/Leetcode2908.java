package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 */
public class Leetcode2908 {
    public static void main(String[] args) {

    }

//    public static int minimumSum(int[] nums) {
//        int ans = Integer.MAX_VALUE;
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                for (int k = j+1; k < n; k++) {
//                    if(nums[i] < nums[j] && nums[k] < nums[j]){
//                        ans = Math.min(nums[i]+nums[j]+nums[k], ans);
//                    }
//                }
//
//            }
//        }
//        return ans == Integer.MAX_VALUE ? -1 : ans;
//    }

    //暴力解法太low，对于三元组的解法，一般是枚举中间变量，然后维护两个数组，进行选择
    public static int minimumSum(int[] nums) {
        int n = nums.length;
        int suf[] = new int[n];       //维护以i后面的最小值
        int ans = Integer.MAX_VALUE;
        suf[n-1] = nums[n-1];
        for(int i = n - 2; i >= 1; i--){
            suf[i] = Math.min(nums[i], suf[i+1]);
        }

        int pre = nums[0];
        for(int i = 1; i < n-1; i++){
            if(pre < nums[i] && nums[i] > suf[i+1]){
                ans = Math.min(ans, pre+nums[i]+suf[i+1]);
            }
            pre = Math.min(pre, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
