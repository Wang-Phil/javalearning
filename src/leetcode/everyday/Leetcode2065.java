package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/1
 *@Time: 14:52
 * 给你一张 无向 图，图中有 n 个节点，节点编号从 0 到 n - 1 （都包括）。同时给你一个下标从 0 开始的整数数组 values ，其中 values[i] 是第 i 个节点的 价值 。同时给你一个下标从 0 开始的二维整数数组 edges ，其中 edges[j] = [uj, vj, timej] 表示节点 uj 和 vj 之间有一条需要 timej 秒才能通过的无向边。最后，给你一个整数 maxTime 。

合法路径 指的是图中任意一条从节点 0 开始，最终回到节点 0 ，且花费的总时间 不超过 maxTime 秒的一条路径。你可以访问一个节点任意次。一条合法路径的 价值 定义为路径中 不同节点 的价值 之和 （每个节点的价值 至多 算入价值总和中一次）。

请你返回一条合法路径的 最大 价值。

注意：每个节点 至多 有 四条 边与之相连。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2065 {
    public static void main(String[] args) {

    }
    //最大化一张图中的路径价值
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        //对其进行暴力搜索
        int n = values.length;
        //构建一张图
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for(int e[] : edges){
            int x = e[0];
            int y = e[1];
            int weight = e[2];
            graph[x].add(new int[]{y, weight});
            graph[y].add(new int[]{x, weight});
        }
        //构建访问数组
        boolean visited[] = new boolean[n];
        visited[0] = true;
        return dfs(0, 0, values[0], visited, graph, values, maxTime);
    }

    private int dfs(int x, int sumTime, int sumValue, boolean[] visited, List<int[]> graph[], int[] values, int maxTime) {
        int res = x == 0 ? sumValue : 0;
        for(int [] edge : graph[x]){
            int y = edge[0];
            int weight = edge[1];
            if(sumTime + weight > maxTime){
                continue;
            }
            if(visited[y]){
                res = Math.max(res, dfs(y, sumTime + weight, sumValue, visited, graph, values, maxTime));
            }else{
                visited[y] = true;
                res = Math.max(res, dfs(y, sumTime + weight, sumValue + values[y], visited, graph, values, maxTime));
                visited[y] = false;
            }
        }
        return res;
    }
}
