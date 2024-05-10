package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/10
 *@Time: 14:59
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */

public class Leetcode153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2,3}));
    }
    //寻找旋转数组的最小值
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;        //这里right取mid，是因为nums[mid]可能是最小值
            }else{
                left = mid + 1;     //这里的话nums[mid]不可能是最小值，所以直接取mid+1
            }
        }
        return nums[right];         //最后面right == left - 1，然后right指向最小值
    }
}
