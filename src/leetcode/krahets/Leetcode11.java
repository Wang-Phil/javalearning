package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/2
 *@Time: 14:24
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。
 */

public class Leetcode11 {
    public static void main(String[] args) {

    }
    //盛更多水的容器
    public int maxArea(int[] height) {
        //双指针
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            }else {
                left++;
            }
        }
        return max;
    }
}
