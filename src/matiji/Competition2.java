package matiji;

import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Competition2 {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int m = input.nextInt();
        int power[] = new int[n];
        //获取到不同点的魔力值
        for(int i = 0; i < n; i++){
            power[i] = input.nextInt();
        }
        //初始化图
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List list = new ArrayList();
            g.add(list);
        }
        //反方向遍历
        int visited[] = new int[n];
        int finalPower[] = new int[n];
        for(int i = 0; i < m; i++){
            int end = input.nextInt() - 1;
            visited[end] = 1;
            int start = input.nextInt() - 1;
            g.get(start).add(end);
        }

        //获取到入度为0的元素

        //获取到最终的power
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> temp = g.get(i);
            finalPower[i] += power[i];
            for(int j = 0; j < temp.size(); j++){
                finalPower[i] += finalPower[temp.get(j)];
            }
            if(visited[i] == 0){
                set.add(i+1);
                dfs(g,i);
                ans.add(finalPower[i]);
            }
        }
        StringBuilder fe = new StringBuilder();
        for(int x : set){
            fe.append(x + " ");
        }
        System.out.println(new String(fe).trim());
        fe = new StringBuilder();
        for(int x : ans){
            fe.append(x + " ");
        }
        System.out.println(new String(fe).trim());
        input.close();
    }

    static void dfs(List<List<Integer>> g, int v){
        List<Integer> temp = g.get(v);
        for(int i = 0; i < temp.size(); i++){
            int u = temp.get(i);
            set.add(u+1);
            dfs(g, u);
        }
    }
}
