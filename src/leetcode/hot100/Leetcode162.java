package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/10
 *@Time: 14:42
 * 峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */

public class Leetcode162 {
    public static void main(String[] args) {

    }
    //红蓝染色法寻找峰值
    public int findPeakElement(int[] nums) {
        //目标：将整个数组进行染色，因为只需要找到一个染色的东西就可以，所以可以把数组染成左右二分的两种颜色
        //染色的逻辑是：假设红色的是小于峰值的元素，蓝色的是大于等于峰值的元素。由于已经假设了数组两边的数组都是无穷小
        //所以可得，nums[0]颜色未知，nums[length - 1]一定是蓝色
        //由于我们只需要找到一个节点就可以，所以可以根据找到中间节点之后，进行判断，然后进行染色
        //nums[mid] nums[mid+1]进行比较，如果 nums[mid] < nums[mid+1],说明左边一定是红色的 left = mid + 1;
        //如果 nums[mid] > nums[mid+1],说明右边一定是蓝色的 right = mid - 1;
        //最后面的话，left指向的是第一个峰值
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
