package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/25
 *@Time: 10:38
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47 {
    public static void main(String[] args) {

    }
    //全排列2
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //不重复的全排列
        int n = nums.length;
        boolean[] used = new boolean[n];
        Arrays.sort(nums);      //排序后，判断
        backTracking(nums, used, 0);
        return ans;
    }
    private void backTracking(int[] nums, boolean[] used, int index) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            //i已经用过了
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]))  continue;
            list.add(nums[i]);
            used[i] = true;
            backTracking(nums, used, i);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
