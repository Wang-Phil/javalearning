package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/6
 *@Time: 9:35
 * 给你一个
二进制数组
nums 。

如果一个
子数组
中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。

返回数组 nums 中交替子数组的数量。
 */

public class Leetcode3101 {
    public static void main(String[] args) {
        System.out.println(countAlternatingSubarrays(new int[]{0,1,1,1}));
    }
    //交替子数组计算
    public static long countAlternatingSubarrays(int[] nums) {
        //交替子数组
        //一次for循环遍历，每次统计交替子数组的最长的长度，然后利用求子数组的公式求的子数组的数量
        long sum = 0;
        long count = 1;
        for (int i = 0; i < nums.length; i++) {
            while(i < nums.length -1 &&  nums[i] != nums[i+1]) {
                count++;
                i++;
            }
            sum += count*(count+1)/2;
            count = 1;
        }
        return sum;
    }
}
