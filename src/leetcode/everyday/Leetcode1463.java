package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/7
 *@Time: 9:42
 * 给你一个 rows x cols 的矩阵 grid 来表示一块樱桃地。 grid 中每个格子的数字表示你能获得的樱桃数目。
你有两个机器人帮你收集樱桃，机器人 1 从左上角格子 (0,0) 出发，机器人 2 从右上角格子 (0, cols-1) 出发。
请你按照如下规则，返回两个机器人能收集的最多樱桃数目：
从格子 (i,j) 出发，机器人可以移动到格子 (i+1, j-1)，(i+1, j) 或者 (i+1, j+1) 。
当一个机器人经过某个格子时，它会把该格子内所有的樱桃都摘走，然后这个位置会变成空格子，即没有樱桃的格子。
当两个机器人同时到达同一个格子时，它们中只有一个可以摘到樱桃。
两个机器人在任意时刻都不能移动到 grid 外面。
两个机器人最后都要到达 grid 最底下一行。
 */

public class Leetcode1463 {
    public static void main(String[] args) {

    }

}
class Solution5 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] f = new int[m + 1][n + 2][n + 2];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < Math.min(n, i + 1); j++) {
                for (int k = Math.max(j + 1, n - 1 - i); k < n; k++) {
                    f[i][j + 1][k + 1] = max(
                            f[i + 1][j][k], f[i + 1][j][k + 1], f[i + 1][j][k + 2],
                            f[i + 1][j + 1][k], f[i + 1][j + 1][k + 1], f[i + 1][j + 1][k + 2],
                            f[i + 1][j + 2][k], f[i + 1][j + 2][k + 1], f[i + 1][j + 2][k + 2]
                    ) + grid[i][j] + grid[i][k];
                }
            }
        }
        return f[0][1][n];
    }

    private int max(int x, int... y) {
        for (int v : y) {
            x = Math.max(x, v);
        }
        return x;
    }
}
