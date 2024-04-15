package leetcode.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode310 {
    public static void main(String[] args) {

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //拓扑排序，不断将出度最小的点排出掉，剩下最后的出度相同的节点就是要求的节点
        List<Integer> ans = new ArrayList<>();      //统计每次拓扑排序的节点，最后一次就是要求的节点
        int[] indegree = new int[n]; //统计所有节点的出度
        List<List<Integer>> edgesmap = new ArrayList<>();   //将数组转换为图的方式进行存储
        //初始化edgesmap
        for(int i = 0; i < n; i++){
            edgesmap.add(new ArrayList<>());
        }

        //首先排出特殊情况，当n只有一个节点的时候
        if(n == 1){
            ans.add(0);
            return ans;
        }

        //然后建立图，统计出度和入度
        for(int edge[] : edges){
            //统计出度和入度
            indegree[edge[0]]++;
            indegree[edge[1]]++;

            //将二维数组转换为图的形式
            edgesmap.get(edge[0]).add(edge[1]);
            edgesmap.get(edge[1]).add(edge[0]);
        }

        //然后建立队列，进行拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){//首先将出度为1的边，加入队列中
            if(indegree[i] == 1) queue.add(i);
        }

        //拓扑排序正式开始
        while(!queue.isEmpty()){
            ans = new ArrayList<>();        //用来接收最后的结果
            int size = queue.size();
            for (int i = 0; i < size; i++) {    //将所有入度为1的节点出队
                int num = queue.poll();
                ans.add(num);
                List<Integer> degree = edgesmap.get(num);//获取出队元素所连接的边
                for (int j = 0; j < degree.size(); j++) {
                    int index = degree.get(j);//获取下标
                    indegree[index]--;  //出度减一
                    if(indegree[index] == 1){   //重新将出度为1的元素加入队列
                        queue.add(index);
                    }
                }
            }
        }
        return ans;
    }
}
