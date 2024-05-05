package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/4
 *@Time: 11:45
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
 */

import java.util.HashMap;
import java.util.Map;

public class Leetcode437 {
    public static void main(String[] args) {

    }
    //双重的递归实现，第一重递归实现遍历所有节点，第二重递归实现遍历
    //暴力解法，但是时间复杂度有点高，可以考虑前缀和
/*    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int ans = rootSum(root, targetSum);
         ans += pathSum(root.left, targetSum);
         ans += pathSum(root.right, targetSum);
         return ans;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ans = 0;
        if (root == null) return 0;
        if(root.val == targetSum) {
            ans++;
        }
        int left = rootSum(root.left, targetSum-root.val);
        int right = rootSum(root.right, targetSum-root.val);
        return ans + left + right;
    }*/

    //前缀和的思路
    Map<Long, Integer> map = new HashMap<>();
    long targetSum = 0;
    public int pathSum(TreeNode root, long targetSum) {
        this.targetSum = targetSum;
        map.put(0L,1);
        return recur(root, 0L);
    }

    public int recur(TreeNode root, Long curSum) {
        if(root == null) return 0;
        curSum += root.val;
        int res = 0;

        res = map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += recur(root.left, curSum);
        res += recur(root.right, curSum);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
        return res;
    }
}
