package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/14
 *@Time: 10:25
 * 给你一座由 n x n 个街区组成的城市，每个街区都包含一座立方体建筑。给你一个下标从 0 开始的 n x n 整数矩阵 grid ，其中 grid[r][c] 表示坐落于 r 行 c 列的建筑物的 高度 。

城市的 天际线 是从远处观察城市时，所有建筑物形成的外部轮廓。从东、南、西、北四个主要方向观测到的 天际线 可能不同。

我们被允许为 任意数量的建筑物 的高度增加 任意增量（不同建筑物的增量可能不同） 。 高度为 0 的建筑物的高度也可以增加。然而，增加的建筑物高度 不能影响 从任何主要方向观察城市得到的 天际线 。

在 不改变 从任何主要方向观测到的城市 天际线 的前提下，返回建筑物可以增加的 最大高度增量总和 。
 */

public class Leetcode807 {
    public static void main(String[] args) {
        System.out.println(maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
    //保持城市天际线
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        //分别遍历，找到最大值
        for(int i = 0; i < m; i++){
            int maxNum = 0;
            for(int j = 0; j < n; j++){
                maxNum = Math.max(maxNum, grid[i][j]);
            }
            row[i] = maxNum;
        }

        for(int i = 0; i < n; i++){
            int maxNum = 0;
            for(int j = 0; j < m; j++){
                maxNum = Math.max(maxNum, grid[j][i]);
            }
            col[i] = maxNum;
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans += Math.min(row[i], col[j]) -  grid[i][j];
            }
        }
        return ans;
    }
}
