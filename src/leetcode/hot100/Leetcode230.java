package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/1
 *@Time: 11:02
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */

public class Leetcode230 {
    public static void main(String[] args) {

    }
    //二叉搜索树找到第k小的值，中序遍历，然后统计
    int ans, k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        if(--k == 0) ans = root.val;
        dfs(root.right);
    }
}
