package leetcode.hot100;

import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Leetcode01 {
    public static void main(String[] args) {
        // 改造，从键盘中获取输入
        int target;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int nums[] = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }
        target = sc.nextInt();
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
