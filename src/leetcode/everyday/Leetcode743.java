package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/18
 *@Time: 9:37
 * 有 n 个网络节点，标记为 1 到 n。

给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。

现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 */

import JavaEE.chapter11.Array01.ArraysExercise;

import java.util.*;

public class Leetcode743 {
    public static void main(String[] args) {

    }
    //网络延迟时间
    public int networkDelayTime(int[][] times, int n, int k) {
        //朴素的dijstra算法，适用于稠密图
        final int INF = Integer.MAX_VALUE/2;    //防止加法溢出
        int[][] graph = new int[n][n];      //领接矩阵
        for(int row[] : graph){
            Arrays.fill(row, INF);
        }
        //初始化领接矩阵
        for(int point[] : times){
            graph[point[0]-1][point[1]-1] = point[2];
        }

        //初始化值
        int maxDis = 0;
        int dis[] = new int[n];
        Arrays.fill(dis, INF);
        dis[k-1] = 0;
        boolean[] visited = new boolean[n];

        //算法实现
        while(true){
            int x = -1;
            //从当前dis中，找到最小的进行更新
            for(int i=0; i<n; i++){
                if(!visited[i] && (x < 0 || dis[i] < dis[x])){
                    x = i;
                }
            }
            if(x < 0){      //没有更新了，那么最后一次算出的最短路径就是最大的
               return maxDis;
            }
            if(dis[x] == INF){  //到达不了其他节点
                return -1;
            }

            //接下来是可以到达并且不是最后一次
            visited[x] = true;
            maxDis = dis[x];        //当前的最短路径
            //更新节点最短路径
            for(int j = 0; j < n; j++){
                dis[j] = Math.min(dis[j], dis[x] + graph[x][j]);
            }
        }
    }

    public int networkDelayTime2(int[][] times, int n, int k) {
        //稀疏图做法，采用最小堆进行实现，存储
        final int INF = Integer.MAX_VALUE/2;    //防止加法溢出
        List<int[]>[] graph = new ArrayList[n];     //领接表
        Arrays.setAll(graph, i -> new ArrayList<>());
        //初始化领接矩阵
        for(int point[] : times){
            graph[point[0] - 1].add(new int[]{point[1]-1, point[2]});
        }

        //初始化值
        int maxDis = 0;
        int left = n; //left表示没有确定最短路径的个数
        int dis[] = new int[n];
        Arrays.fill(dis, INF);
        dis[k-1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[0]-b[0]));     //最小堆
        pq.offer(new int[]{0, k-1});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int dx = cur[0];
            int x = cur[1];
            if(dx > dis[x]) //x之前已经出现过，就不用再更新了
                continue;
            maxDis = dx;        //当前的最短路径
            left--;
            for(int[] edge : graph[x]){     //当前最短的点
                int y = edge[0];
                int newDis = dx + edge[1];
                if(newDis < dis[y]){
                    dis[y] = newDis;        //更新最短距离
                    pq.offer(new int[]{newDis, y});
                }

            }
        }
        return left == 0 ?  maxDis : -1;
    }
}
