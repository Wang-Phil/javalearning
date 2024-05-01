package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/1
 *@Time: 11:30
 */

import java.util.LinkedList;
import java.util.List;

public class Leetcode199 {
    public static void main(String[] args) {

    }
    List<Integer> ans = new LinkedList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        leftSideView(root, 0);
        return ans;
    }
    public void leftSideView(TreeNode root,int depth) {
        //先递归右子树，然后递归左子树。
        if(root == null) return;
        if(depth == ans.size())  ans.add(root.val);
        leftSideView(root.right, depth + 1);
        leftSideView(root.left, depth + 1);
    }
}
