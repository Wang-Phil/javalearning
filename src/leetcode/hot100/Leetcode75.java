package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/27
 *@Time: 10:38
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */

import java.util.Arrays;

public class Leetcode75 {
    public static void main(String[] args) {
        sortColors1(new int[]{2,0,2,1,1,1,0});
    }
    //75.颜色分类
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                red++;
            }else if(nums[i] == 1){
                white++;
            }else{
                blue++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(red != 0){
                nums[i] = 0;
                red--;
            }else if(white != 0){
                nums[i] = 1;
                white--;
            }else{
                nums[i] = 2;
                blue--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors1(int[] nums) {
        int n = nums.length;
        int n0 = 0, n1 = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            nums[i] = 2;
            if(num < 2){
                nums[n1++] = 1;
            }
            if(num < 1){
                nums[n0++] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
