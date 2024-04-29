package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/29
 *@Time: 15:27
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94 {
    public static void main(String[] args) {

    }
    static List<Integer> ans = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        InOrder(root);
        return ans;
    }
    //递归实现比较简单，接下来重温一下非递归实现
/*    public static void InOrder(TreeNode root) {
        if(root != null){
            InOrder(root.left);
            ans.add(root.val);
            InOrder(root.right);
        }
    }*/

    //非递归
    public static void InOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
