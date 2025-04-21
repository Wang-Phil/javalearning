package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/11
 *@Time: 10:35
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。
 */

public class Leetcode4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}));
    }
    //寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //难度有点大，先看题解了
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        //分割线左边元素的满足的个数是 （m+n+1)/2
        int totalLeft = (m + n + 1) / 2;

        //然后再nums1中找到合适的分割线，[0,m],使其满足nums1[i - 1] <= nums2[j] && nums[j - 1] <= nums[i]
        int left = 0;
        int right = m;

        while(left  < right){
            int i = left + (right - left + 1) / 2;        //+1是为了防止进入死循环,保证nums1[i-1]大于0
            int j = totalLeft - i;
            if(nums1[i - 1] > nums2[j]){                //nums[i-1]太大了，要在左边元素进行查找[left, i-1]进行查找
                right = i - 1;
            }else{
                left = i;                                  //下一轮搜索的区间是[i, right]
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if((m + n) % 2 == 1){//如果是奇数，就返回左边的最大值
            return Math.max(nums1LeftMax, nums2LeftMax);
        }else{//如果是偶数，就找到左边最大值，右边最小值，除以2
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }
}
