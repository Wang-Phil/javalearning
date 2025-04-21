package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/25
 *@Time: 11:01
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    //定义全局变量
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean used[];
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        BackTracking(candidates, target, 0);
        return res;
    }

    private void BackTracking(int[] candidates, int target, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) {continue;}
            list.add(candidates[i]);
            used[i] = true;
            BackTracking(candidates, target - candidates[i], i+1);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
