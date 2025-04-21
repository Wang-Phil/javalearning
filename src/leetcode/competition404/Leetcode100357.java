package leetcode.competition404;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/30
 *@Time: 11:12
 * 给你一个整数数组 nums。

nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：

(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
返回 nums 的 最长的有效子序列 的长度。

一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。
 */

public class Leetcode100357 {
    public static void main(String[] args) {
        // 测试用例
        System.out.println(maximumLength(new int[]{1, 2, 3, 4})); // 示例 1
        System.out.println(maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2})); // 示例 2
        System.out.println(maximumLength(new int[]{4,2,6})); // 示例 3
    }
    //找出有效子序列的最大长度1
    public static int maximumLength(int[] nums) {
        if ( nums.length <= 2) return nums.length;

        int n = nums.length;
        int maxLength = 1;
        int isOdd = 0;
        int isEven = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                isEven++;
            }else{
                isOdd++;
            }
        }
        maxLength = Math.max(isOdd, isEven);
        maxLength = Math.max(maxLength,first(nums));
        return maxLength;
    }

    //第一种奇偶交换
    private static int first(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        int isOdd = nums[0] % 2;
        for (int i = 1; i < n; i++) {
            if(isOdd != nums[i] % 2){
                maxLength++;
                isOdd = nums[i] % 2;
            }
        }
        return maxLength;
    }

}
