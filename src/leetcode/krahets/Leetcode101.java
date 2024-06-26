package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/26
 *@Time: 21:01
 */

import java.util.Scanner;

public class Leetcode101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricTree(root.left, root.right);
    }
    private boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isSymmetricTree(left.right, right.left) && isSymmetricTree(left.left, right.right);
    }
}
