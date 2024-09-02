package leetcode.competition412;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/8/25
 * @Time: 10:45
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 *
 * 你需要对 nums 执行 k 次操作，每次操作中：
 *
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
 **/
public class LeetcodeQ1 {
    public static void main(String[] args) {

    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //k次操作每次找最小值
        //暴力搜索
        int n = nums.length;
        int min = nums[0];
        int index = 0;
        for(int i = 0; i < k; i++){
            min = nums[0];
            index = 0;
            for(int j = 0; j < n; j++){
                if(min > nums[j]){
                    min = nums[j];
                    index = j;
                }
            }
            nums[index] = min * multiplier;
        }
        return nums;
    }
}
