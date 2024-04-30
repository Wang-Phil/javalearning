package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/30
 *@Time: 10:18
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        //将其转化为子树是否是对称
        if(root == null) return false;
        return isSymmetricTree(root.left, root.right);
    }
    boolean isSymmetricTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isSymmetricTree(root1.left, root2.right) && isSymmetricTree(root1.right, root2.left);
    }
}
