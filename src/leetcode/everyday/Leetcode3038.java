package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/7
 *@Time: 9:23
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作：

选择 nums 中的前两个元素并将它们删除。
一次操作的 分数 是被删除元素的和。

在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。

请你返回按照上述要求 最多 可以进行的操作次数。
 */

public class Leetcode3038 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3,2,6,4,5}));
    }
    //相同分数的最大操作数目1
    public static int maxOperations(int[] nums) {
        //直接遍历就可以
        int sum = nums[0] + nums[1];
        int count = 1;
        for(int i = 2; i < nums.length-1; i+=2) {
            if(nums[i] + nums[i+1] == sum) {
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
