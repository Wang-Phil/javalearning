package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/30
 *@Time: 10:07
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class Leetcode226 {
    //递归是自底向上
/*    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }*/
    //遍历是自顶向下
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
            //交换左右子树
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
