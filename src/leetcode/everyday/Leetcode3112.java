package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/18
 *@Time: 8:43
 * 给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间有一条需要 lengthi 单位时间通过的无向边。
同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么 answer[i] 为 -1 。
 */

import java.util.*;

public class Leetcode3112 {
    public static void main(String[] args) {

    }
    //访问消失节点的最少时间
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        //在创建图的时候就进行判断这个点是否可以创建，然后构建一个新的图，采用dijstra算法进行实现单源最短路径问题
        //稀疏图做法，采用最小堆进行实现，存储
        final int INF = Integer.MAX_VALUE/2;    //防止加法溢出
        List<int[]>[] graph = new ArrayList[n];     //领接表
        Arrays.setAll(graph, i -> new ArrayList<>());
        //初始化领接表，无向图
        for(int point[] : edges){
            int x = point[0];
            int y = point[1];
            int value = point[2];
            graph[x].add(new int[]{y, value});
            graph[y].add(new int[]{x, value});
        }

        //初始化值
        int maxDis = 0;
        int dis[] = new int[n];
        Arrays.fill(dis, -1);
        dis[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[0]-b[0]));     //最小堆
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int dx = cur[0];
            int x = cur[1];
            if(dx > dis[x]) //x之前已经出现过，就不用再更新了
                continue;
            maxDis = dx;        //当前的最短路径
            for(int[] edge : graph[x]){     //当前最短的点
                int y = edge[0];
                int newDis = dx + edge[1];
                if(newDis < disappear[y] && (dis[y] < 0 || newDis < dis[y])){
                    dis[y] = newDis;        //更新最短距离
                    pq.offer(new int[]{newDis, y});
                }

            }
        }
        return dis;
    }
}
