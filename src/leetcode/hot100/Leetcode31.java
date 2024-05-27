package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/27
 *@Time: 10:52
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。

例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。

必须 原地 修改，只允许使用额外常数空间。
 */

public class Leetcode31 {
    public static void main(String[] args) {

    }
    //下一个排列
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;

        //举例：12354 下一个排列为12435
        //第一步：从后面往前找到第一个升序的两个值
        int pos = -1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                pos = i;
                break;
            }
        }
        //没有更大的排序了，直接返回最小排序，对其进行排序
        if(pos == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        //第二步：找到第一个大于nums[pos]的值，从后往前找
        for(int i=nums.length-1; i> pos; i--) {
            if(nums[pos] < nums[i]) {
                swap(nums, pos, i);
                break;
            }
        }
        //第三步：给【pos+1, length)进行倒转一下
        reverse(nums, pos+1, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
