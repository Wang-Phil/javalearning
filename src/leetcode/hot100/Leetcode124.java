package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/5
 *@Time: 10:20
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */

public class Leetcode124 {

}

class Solution {
    //二叉树的最大路径和
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return maxPath(root);
    }
    public int maxPath(TreeNode root) {
        if(root == null) return 0;
        //左右子树的最大值取决于当前节点和o，如果是负数就不取
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        //实际的最大路径就是当前节点和左右子树的最大节点
        int max = root.val + left + right;
        ans  = Math.max(ans, max);
        //返回的时候是返回当前节点的最大值，为左子树和右子树的最大值加上当前节点的最大值
        return root.val + Math.max(left, right);
    }
}
