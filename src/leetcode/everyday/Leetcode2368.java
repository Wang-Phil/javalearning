package leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2368 {
    public static void main(String[] args) {
        Leetcode2368 leetcode2368 = new Leetcode2368();

    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //建树，建树的一般步骤是采用list进行。
        //判断是否这个节点受限制,对其进行标记
        boolean isrestricted[] = new boolean[n];
        for(int x : restricted){
            isrestricted[x] = true;
        }
        //将edges转为二维数组，只有当两个节点都不是受限制的条件下，才去建立边
        List<Integer> g[] = new List[n];
        Arrays.setAll(g, i->new ArrayList<>());         //初始化二维list
        for(int edge[] : edges){
            int x = edge[0];
            int y = edge[1];
            if(!isrestricted[x] && !isrestricted[y]){
                g[x].add(y);
                g[y].add(x);
            }
        }
        int count = dfs(0, -1, g);
        return count;
    }

    //新的遍历方式，不需要visited数组就可以遍历一次以某个根节点的树
    int dfs(int x, int f, List<Integer> g[]){
        int ans = 0;
        for(int y : g[x]){
            if(y != f){
                ans += dfs(y, x, g);
            }
        }
        return ans;
    }
}
