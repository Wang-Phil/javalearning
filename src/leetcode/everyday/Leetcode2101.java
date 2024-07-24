package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/22
 *@Time: 9:52
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。

炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。

你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。

给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2101 {
    public static void main(String[] args) {

    }
    //引爆最多的炸弹
    public int maximumDetonation(int[][] bombs) {
        //将其转换为有向图
        int n = bombs.length;
        List<Integer>[] list = new ArrayList[n];
        Arrays.setAll(list, i -> new ArrayList<Integer>());
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                long dx = bombs[j][0] - x;
                long dy = bombs[j][1] - y;
                if(dx * dx + dy * dy <= r*r) {
                    list[i].add(j);     //i可以引爆j，建立有向图
                }
            }
        }

        int ans = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            ans = Math.max(ans, dfs(list, visited, i));
        }
        return ans;
    }

    private int dfs(List<Integer>[] list, boolean[] visited, int x) {
        visited[x] = true;
        int cnt = 1;
        for(int y : list[x]) {
            if(!visited[y]) {
                cnt += dfs(list, visited, y);
            }
        }
        return cnt;
    }
}
