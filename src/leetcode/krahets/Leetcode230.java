package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/21
 *@Time: 10:15
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */

public class Leetcode230 {
    public static void main(String[] args) {

    }
    int ans , k;
    //二叉搜索树的第k小的元素
    public int kthSmallest(TreeNode root, int k) {
        //二叉搜索树的性质，中序遍历可以实现递增
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if(--k == 0) {
            ans = root.val;
            return;
        }
        dfs(root.right);
    }
}
