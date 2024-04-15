package leetcode.hot100;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class Leetcode11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int volumn = 0;
        while(left < right){
            int hai = height[left] < height[right] ? height[left] : height[right];
            volumn = Math.max(volumn, hai * (right - left));
            if(height[left] < height[right]){
                left++;
            }
            else
                right--;
        }
        return volumn;
    }

}
