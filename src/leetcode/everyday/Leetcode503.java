package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/24
 *@Time: 9:48
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 */

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode503 {
    public static void main(String[] args) {

    }
    //下一个更大元素2
    public int[] nextGreaterElements(int[] nums) {
        //单调栈，但是因为是可以循环的，所以采取数组的两倍进行
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 2*n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()%n] <= nums[i%n]){
                stack.pop();
            }
            res[i%n] = stack.isEmpty() ? -1 : nums[stack.peek()%n];
            stack.push(i);
        }
        return res;
    }
}
