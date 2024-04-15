package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Leetcode01 {
    public static void main(String[] args) {
        int nums[] = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        //改进一次for循环即可
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                return new int[]{hashMap.get(nums[i]),i};
            }
            hashMap.put(target-nums[i], i);
        }
        return new int[]{};
    }
}
