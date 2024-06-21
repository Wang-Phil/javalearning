package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/21
 *@Time: 9:59
 */

public class Leetcode236 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //二叉树找最近公共祖先，采用递归的先序遍历方式进行改造

        //首先判断当前节点是否是p或者q，如果是就直接返回，或者当root为空时，已经到达叶节点，也是直接返回root即可，综上，直接返回root
        if(root==null || root==p || root==q) return root;

        //深度递归遍历左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //然后判断左右子树情况，向上递归
        //如果左右子树都为空，说明p，q到目前为止都还没有找到
        if(left==null && right==null) return null;

        //如果左子树为空，左子树不存在q，p节点，直接返回右子树
        if(left==null) return right;

        //同理，如果右子树为空，右子树不存在q，p节点，直接返回左子树
        if(right==null) return left;

        //这时候只剩下左子树不为空，右子树也不为空的情况，由于是第一个遍历到左右子树都不为空的节点，这时候就是最近的公共祖先节点,直接返回root
        return root;

    }

}
