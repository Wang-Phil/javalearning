package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/25
 *@Time: 20:27
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，以及整数 indexDifference 和整数 valueDifference 。

你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：

abs(i - j) >= indexDifference 且
abs(nums[i] - nums[j]) >= valueDifference
返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；否则，answer = [-1, -1] 。如果存在多组可供选择的下标对，只需要返回其中任意一组即可。

注意：i 和 j 可能 相等 。
 */

public class Leetcode2903 {
    public static void main(String[] args) {

    }
    //找出满足差值条件的下标1
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        //在O(n)的时间复杂度下完成
        int minIndex = 0, maxIndex = 0;
        for(int j = indexDifference; j < nums.length; j++){
            int i = j - indexDifference;
            if(nums[minIndex] > nums[i]){
                minIndex = i;
            }
            if(nums[j] - nums[minIndex] >= valueDifference){
                return new int[]{minIndex, j};
            }
            if(nums[maxIndex] < nums[i]){
                maxIndex = i;
            }
            if(nums[maxIndex] - nums[j] >= valueDifference){
                return new int[]{maxIndex, j};
            }
        }
        return new int[]{-1,-1};
    }
}
