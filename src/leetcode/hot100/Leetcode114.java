package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/2
 *@Time: 12:23
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode114 {
    public static void main(String[] args) {

    }
    //二叉树展开为链表，顺序是先序遍历的顺序
    //1、第一种做法，非递归算法，左子树变成右子树，右子树放到左子树的最右边节点
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为空，就直接在右子树进行操作
            if (root.left == null) {
                root = root.right;
            //不为空的话，先找到左子树最右边的节点
            }else{
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                //然后将左子树接到右子树上面，右子树接到temp节点的下面，将左子树置为空
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
                //继续下一个节点的操作
                root  = root.right;
            }
        }
    }

    //第二种解法，就是采用后序遍历的思想，保存了前一个节点的情况下，把当前节点的右指针指向前一个节点。然后将当前节点的左子树置为空
    TreeNode prev = null;
    public void flatten1(TreeNode root) {
        if(root == null) return;
        flatten1(root.right);
        flatten1(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //第三种解法，先序遍历的变形可以保存节点，非递归的实现
    public void flatten2(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(prev != null) {
                prev.right = node;
                prev.left = null;
            }
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            prev = node;
        }
    }
}
