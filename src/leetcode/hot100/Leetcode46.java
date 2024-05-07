package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/7
 *@Time: 13:35
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    //回溯算法 全排列
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean used[] = new boolean[n];
        backTracking(nums, used, 0);
        return res;
    }

    public static void backTracking(int [] nums, boolean used[], int i){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int j = 0; j < nums.length; j++){
            if(used[j]){continue;}          //用过了，就不需要在加入到数组当中了
            used[j] = true;
            list.add(nums[j]);
            backTracking(nums, used, j+1);
            used[j] = false;
            list.remove(list.size()-1);
        }
    }



}
