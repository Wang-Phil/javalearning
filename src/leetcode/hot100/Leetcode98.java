package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/1
 *@Time: 10:22
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树
只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */

public class Leetcode98 {
    public static void main(String[] args) {

    }
    //先序遍历，判断范围是否符合规范
/*    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long left, long right) {
        if(root == null) return true;
        long x = root.val;
        return left < x && x < right && isValidBST(root.left, left, x) && isValidBST(root.right, x, right);
    }*/

    //中序遍历
/*    TreeNode preNode = null;
    //验证一个二叉搜索树，采用中序遍历，判断是否满足是递增的状态
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root);
    }

    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        boolean left =  isValidBST2(root.left);
        if(preNode != null && root.val <= preNode.val) return false;
        preNode = root;
        boolean right =  isValidBST2(root.right);
        return left && right;
    }*/

    //后序遍历的实现
    public boolean isValidBST(TreeNode root) {
        return dfs(root)[1] != Long.MAX_VALUE;
    }
    private long[] dfs(TreeNode root) {
        if(root == null) return new long[] {Long.MAX_VALUE, Long.MIN_VALUE};
        long[] left = dfs(root.left);
        long[] right = dfs(root.right);
        if(root.val <= left[1] || root.val >= right[0]){
            return new long[] {Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[] {Math.min(left[0], root.val), Math.max(root.val, right[1])};
    }
}
