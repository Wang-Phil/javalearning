package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/29
 *@Time: 15:36
 */

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode104 {
    public static void main(String[] args) {
    }
/*    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        return Math.max(ldepth, rdepth)+1;
    }*/
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return depth;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode p = queue.poll();
                if(p.left != null) queue.offer(p.left);
                if(p.right != null) queue.offer(p.right);
            }
            depth++;
        }
        return depth;
    }
}
