package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/24
 *@Time: 9:41
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
每分钟，如果节点满足以下全部条件，就会被感染：
节点此前还没有感染。
节点与一个已感染节点相邻。
返回感染整棵树需要的分钟数。
 */

import java.util.*;

public class Leetcode2385 {
    public static void main(String[] args) {

    }
   /* //先进行深度优先搜索，建立一个无向图，然后再从start节点开始宽度优先搜索
    public  int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        dfs(map, root);
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(start); // 添加当前节点，表示已经访问过
        queue.add(new int[]{start, 0});
        int time = 0;
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            time = cur[1];
            int node = cur[0];
            for (int child : map.get(node)) {
                if (visited.add(child)) {
                    queue.offer(new int[]{child, time+1});
                }
            }
        }
        return time;
    }

    // 深度优先搜索构建以map进行存储的无向图
    public void dfs(Map<Integer, List<Integer>> map, TreeNode root) {// 求树高
        map.putIfAbsent(root.val, new ArrayList<Integer>());
        for (TreeNode child : Arrays.asList(root.left, root.right)) {// 深度优先搜索建立无向图
            if (child != null) {
                map.get(root.val).add(child.val);// 无向图的第一个顶点
                map.putIfAbsent(child.val, new ArrayList<>());
                map.get(child.val).add(root.val);// 无向图的第二个顶点
                dfs(map, child);
            }
        }
    }*/

    private int ans;
    public  int amountOfTime(TreeNode root, int start) {
        dfs(root,start);
        return ans;
    }
    private int[] dfs(TreeNode root, int start) {
        if(root == null) return new int[]{0,0};

        int[] left = dfs(root.left, start);
        int[] right = dfs(root.right, start);
        int lleft = left[0], lfound = left[1];
        int lright = right[0], rfound = right[1];
        if(root.val  == start){//计算最大深度
            ans = Math.max(lleft,lright);
            return new int[]{1,1};
        }
        if(lfound == 1 || rfound == 1){
            ans = Math.max(ans, lleft + lright);
            return new int[]{(lfound == 1 ? lleft : lright)+1, 1};
        }
        return new int[]{Math.max(lleft,lright)+1,0};
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
