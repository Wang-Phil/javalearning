package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/5
 *@Time: 17:32
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。


 */

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode994 {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1}, {1,1,1}, {0,1,2}}));
    }
    //腐烂的橘子,这里采用的是bfs进行遍历
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int neworange = 0;
        Deque<int[]> queue = new LinkedList<>();
        //先统计新鲜橙子的个数，然后将当前已经腐烂的橙子加入到队列当中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    neworange++;
                }
                else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //然后层序遍历
        int count = 0;      //统计腐烂的次数
        while(neworange > 0 && !queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                //上面
                if(x - 1 >= 0 && grid[x - 1][y] == 1) {
                    queue.offer(new int[]{x - 1, y});
                    neworange--;
                    grid[x - 1][y] = 2;
                }
                //下面
                if(x + 1 < m && grid[x + 1][y] == 1) {
                    queue.offer(new int[]{x + 1, y});
                    neworange--;
                    grid[x + 1][y] = 2;
                }
                //左边
                if(y - 1 >= 0 && grid[x][y - 1] == 1) {
                    queue.offer(new int[]{x, y - 1});
                    neworange--;
                    grid[x][y - 1] = 2;
                }
                //右边
                if(y + 1 < n && grid[x][y + 1] == 1) {
                    queue.offer(new int[]{x, y + 1});
                    neworange--;
                    grid[x][y + 1] = 2;
                }
            }
        }
        if(neworange > 0) {
            return -1;
        }
        return count;
    }


    //也可以深度优先遍历
    public static int orangesRotting1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 2); //初始的时间从2开始
                }
            }
        }

        int mintime = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                mintime = Math.max(mintime, grid[i][j]);
            }
        }
        return mintime == 0 ? 0 : mintime - 2;
    }

    public static void dfs(int[][] grid, int i , int j, int time) {
        //如果i,j下标超过了，直接返回
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {return;}
        //如果当前橘子不是新鲜的，并且腐烂的时间不是最快的，也是返回
        if(grid[i][j] != 1 && grid[i][j]  < time) {return;}

        grid[i][j] = time;          //设置当前腐烂时间
        //朝着不同方向进行递归
        dfs(grid, i + 1, j, time+1);
        dfs(grid, i - 1, j, time+1);
        dfs(grid, i, j + 1, time+1);
        dfs(grid, i, j - 1, time+1);
    }
}
