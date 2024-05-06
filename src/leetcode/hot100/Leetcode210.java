package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/6
 *@Time: 11:20
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 */

import java.util.*;

public class Leetcode210 {
    public static void main(String[] args) {

    }
    //课程表2，相比于1的话，是需要输出一个序列
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //申请二维list,作为图的存储方式
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        //入度的数组
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;            //入度加1
        }
        //用来统计结果
        List<Integer> ans = new ArrayList<>();
        //申请队列
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);         //将入度为0的课程加入到队列当中
            }
        }
        //然后拓扑排序
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int u = queue.poll();       //得到入度为0的节点，然后遍历
            ans.add(u);
            for(int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) { //将新的入度为0的节点加入到队列当中
                    queue.offer(v);
                }
            }
        }
        if(count == numCourses) {
            return ans.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }
}
