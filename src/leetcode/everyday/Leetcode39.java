package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 10:09
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {
    public static void main(String[] args) {

        System.out.println(combinationSum(new int[]{2,3,4,5,6}, 10));
    }
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    static List<Integer> list = new ArrayList();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //回溯算法题
        backtrack(candidates, target, 0);
        return  res;

    }
    public static void backtrack(int[] candidates, int target, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
