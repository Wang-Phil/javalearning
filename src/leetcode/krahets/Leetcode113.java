package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/24
 *@Time: 10:26
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    //路径总合2
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list =  new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        list.add(root.val);
        if(sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        list.remove(list.size()-1);
    }
}
