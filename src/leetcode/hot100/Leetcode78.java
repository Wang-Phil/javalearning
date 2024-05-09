package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/7
 *@Time: 14:35
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
子集
（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    public static void main(String[] args) {

    }
    //回溯算法， 子集
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int start) {
        if(start > nums.length) return;
        res.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
