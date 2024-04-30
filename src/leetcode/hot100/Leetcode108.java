package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/30
 *@Time: 10:36
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡二叉搜索树。
 */

public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return  ArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode ArrayToBST(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = ArrayToBST(nums, start, mid-1);
        root.right = ArrayToBST(nums, mid+1, end);
        return root;
    }
}
