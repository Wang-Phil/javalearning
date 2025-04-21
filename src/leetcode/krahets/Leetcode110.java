package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/27
 *@Time: 22:33
 * 给定一个二叉树，判断它是否是
平衡二叉树

 */

public class Leetcode110 {
    public static void main(String[] args) {

    }
    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root) == -1 ? false : true;
    }

    private int isBalancedTree(TreeNode root) {
        if (root == null) return 0;
        int left = isBalancedTree(root.left);
        int right = isBalancedTree(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
