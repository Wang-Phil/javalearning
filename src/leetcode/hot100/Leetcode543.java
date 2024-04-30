package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/30
 *@Time: 10:25
 * 给你一棵二叉树的根节点，返回该树的 直径 。
二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
两节点之间路径的 长度 由它们之间边数表示。
 */

public class Leetcode543 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    public int depth(TreeNode root) {
        if (root == null) return -1;
        int left = depth(root.left)+1;
        int right = depth(root.right)+1;
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
