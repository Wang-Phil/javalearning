package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */
public class Leetcode560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
/*    public static int subarraySum(int[] nums, int k) {
        //直接暴力解法
        int ans = 0;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == k) ans++;
            }
        }
        return ans;
    }*/

/*    //前缀和进行优化
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        int n = nums.length;
        int pre_sum[] = new int[n + 1];
        pre_sum[0] = 0;
        //计算前缀和
        for (int i = 0; i < n; i++) {
            pre_sum[i+1] = pre_sum[i] + nums[i];
        }
        //双重for循环遍历找到符合的
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (pre_sum[j+1] - pre_sum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }*/

    public static int subarraySum(int[] nums, int k) {
        //前缀和加上hash可以实现时间复杂度的降维，从n^2转变为n
        //类似于两数之和的题目，两数之和保存的sum-num1
        //这里保存的是presum前缀和。
        //整体实现的思路就是，在求前缀和的过程中保存前缀和，还有他出现的次数。
        //然后在遍历的过程中，判断hash表中是否出现了另外一个presum，两个presum之差就是k
        //公式为 presum1  - presum2 = k,之前存的是presum2，所以转换为查找 presum1 - k
        int ans = 0;
        int presum = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0,1);
        int n = nums.length;
        for(int x : nums){
            presum += x;
            if(preSumMap.containsKey(presum - k)){
                ans += preSumMap.get(presum - k);
            }
            preSumMap.put(presum, preSumMap.getOrDefault(presum, 0)+1);
        }
        return ans;
    }
}
