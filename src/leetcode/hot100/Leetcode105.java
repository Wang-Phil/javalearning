package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/2
 *@Time: 13:19
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */

import java.util.HashMap;

public class Leetcode105 {
    public static void main(String[] args) {

    }
    int preorder[];
    HashMap<Integer, Integer> map = new HashMap<>();
    //将中序遍历的数组存在map当中，后序可以比较方便的找到根节点，省去了一些时间复杂度
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0,0,inorder.length - 1);
    }
    public TreeNode recur(int root, int left, int right) {
        if(left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = map.get(preorder[root]);
        //左子树的下次遍历的根节点就是root+1
        node.left = recur(root + 1, left, i - 1);
        //而右子树大下次遍历的根节点就是当前根节点+左子树长度+1
        node.right = recur(root+i-left+1, i + 1, right);
        return node;
    }
}
