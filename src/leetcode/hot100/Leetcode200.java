package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/5
 *@Time: 17:07
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。
 */

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode200 {
    int visited[];
    public static void main(String[] args) {

    }
    //深度优先搜索
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    //深度优先搜索
    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){return;}
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    //宽度优先搜索
    public void bfs(char[][] grid, int i, int j) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1'){
                grid[i][j] = '0';
                queue.offer(new int[]{i-1, j});
                queue.offer(new int[]{i+1, j});
                queue.offer(new int[]{i, j-1});
                queue.offer(new int[]{i, j+1});
            }
        }
    }
}
