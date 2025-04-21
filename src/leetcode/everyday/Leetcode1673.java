package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/24
 *@Time: 8:49
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。
例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 */

public class Leetcode1673 {
    public static void main(String[] args) {

    }
    //找出最具竞争力的子序列
    //类似于单调栈的一个思路
    public int[] mostCompetitive(int[] nums, int k) {
        //单调栈，维护一个从左到右最小的长度为k的子序列
        //这里采用数组进行模拟栈
        int stack[] = new int[k];
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            //如果当前下标大于0，并且栈顶元素比x大，栈的大小加上数组剩余元素的大小要大于k，这时候可以弹出栈顶元素
            while(index > 0 && x < stack[index-1] && index + n - i  > k){
                index--;
            }
            if(index < k){
                stack[index++] = x;
            }
        }
        return stack;
    }
}
