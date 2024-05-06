package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/6
 *@Time: 10:20
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode207 {
    public static void main(String[] args) {

    }
    //课程表
    //有向边，构成图之后，判断是否可以完成图的遍历，拓扑排序 bfs实现
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        //申请队列
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);         //将入度为0的课程加入到队列当中
            }
        }
        //然后拓扑排序
        int count = 0;              //统计访问节点
        while (!queue.isEmpty()) {
            count++;
            int u = queue.poll();       //得到入度为0的节点，然后遍历
            for(int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) { //将新的入度为0的节点加入到队列当中
                    queue.offer(v);
                }
            }
        }
        return count == numCourses;
    }

    //也可以dfs实现
    //定义三种状态，flag[i] == 0,表示没有访问过  flag[i] == -1 表示当前节点已经被其他节点访问过, flag[i] == 1 本节点启动dfs访问过
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        //申请二维list,作为图的存储方式
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        //遍历树，对其进行访问，判断是否存在环
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(graph, flags, i)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int flags[], int i ) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;        //只有这个标志位是干净的，别人还没有动过，我才能标记为1，说明本次dfs我遍历过它
        for(int v : graph.get(i)) {
            if(!dfs(graph, flags, v)) return false;
        }
        flags[i] = -1;   //只有一次DFS完整结束了，才能执行到这一步，标记为-1，说明这条路没问题，再遇到不需要遍历了
        return true;
    }

}
