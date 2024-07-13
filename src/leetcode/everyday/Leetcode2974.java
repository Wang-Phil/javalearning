package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/12
 *@Time: 10:21
 * 你有一个下标从 0 开始、长度为 偶数 的整数数组 nums ，同时还有一个空数组 arr 。Alice 和 Bob 决定玩一个游戏，游戏中每一轮 Alice 和 Bob 都会各自执行一次操作。游戏规则如下：
每一轮，Alice 先从 nums 中移除一个 最小 元素，然后 Bob 执行同样的操作。
接着，Bob 会将移除的元素添加到数组 arr 中，然后 Alice 也执行同样的操作。
游戏持续进行，直到 nums 变为空。
返回结果数组 arr 。
 */

import java.util.Arrays;

public class Leetcode2974 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberGame(new int[]{1})));
    }
    //最小数字游戏
    public static int[] numberGame(int[] nums) {
        //分别移动
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.sort(nums);
        for (int i = 0; i < n-1; i+=2) {
            ans[i] = nums[i+1];
            ans[i+1] = nums[i];
        }
        if(n % 2 == 1) {
            ans[n-1] = nums[n-1];
        }
        return ans;
    }
}
