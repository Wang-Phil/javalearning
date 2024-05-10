package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/10
 *@Time: 14:16
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */

public class Leetcode33 {
    public static void main(String[] args) {
        System.out.println(search1(new int[]{4,5,6,7,0,1,2}, 0));
    }
    //搜索旋转数组
    //第一种方法：两次二分，首先第一次二分找到数组中的最小值，target进行对比，再选择一个区间进行二分
    public static int search(int[] nums, int target) {
        int n = nums.length - 1;
        int min = findMin(nums);
        int index = 0;
        if(target > nums[n]){
           index =  lower_bound(nums, 0, min,target);
        }else{
            index =  lower_bound(nums, min, n,target);
        }
        if(index == nums.length || nums[index] != target){  //特殊情况的判断
            return -1;
        }else{
            return index;
        }
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;           //返回下标
    }

    public static int lower_bound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    //第二种方法：一次二分
    public static int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(isRight(nums, mid, target)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] != target){return -1;} //没找到
        return left;           //找到了
    }

    public static boolean isRight(int[] nums, int mid, int target) {
        int end = nums[nums.length - 1];
        if(nums[mid] > end){
            return target > end && nums[mid] >= target;
        }else{
            return target > end || nums[mid] >= target;
        }

    }
}
