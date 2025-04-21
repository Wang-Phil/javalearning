package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/25
 *@Time: 10:27
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {
    public static void main(String[] args) {

    }
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean visited[] = new boolean[n];
        backTracking(nums, visited, 0);
        return ans;
    }
    private void backTracking(int[] nums, boolean[] visited, int i) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        for(int j = 0; j < nums.length; j++) {
            if(visited[j] == false) {
                list.add(nums[j]);
                visited[j] = true;
                backTracking(nums, visited, j);
                list.remove(list.size() - 1);
                visited[j] = false;
            }
        }
    }
}
