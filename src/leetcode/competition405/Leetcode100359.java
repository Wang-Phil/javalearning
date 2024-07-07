package leetcode.competition405;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/7
 *@Time: 10:40
 * 给你一个二维字符矩阵 grid，其中 grid[i][j] 可能是 'X'、'Y' 或 '.'，返回满足以下条件的
子矩阵
数量：

包含 grid[0][0]
'X' 和 'Y' 的频数相等。
至少包含一个 'X'。
 */

public class Leetcode100359 {
    public static void main(String[] args) {
        char[][] grid1 = {
                {'X', 'Y', '.'},
                {'Y', '.', '.'}
        };

        char[][] grid2 = {
                {'X', 'X'},
                {'X', 'Y'}
        };

        char[][] grid3 = {
                {'.', '.'},
                {'.', '.'}
        };

        System.out.println(numberOfSubmatrices(grid1)); // 输出: 3
        System.out.println(numberOfSubmatrices(grid2)); // 输出: 0
        System.out.println(numberOfSubmatrices(grid3)); // 输出: 0
    }
    //统计x和y频数相等的子矩阵数量
    public static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefixX = new int[m + 1][n + 1];
        int[][] prefixY = new int[m + 1][n + 1];

        // 构建前缀和矩阵
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixX[i][j] = prefixX[i - 1][j] + prefixX[i][j - 1] - prefixX[i - 1][j - 1];
                prefixY[i][j] = prefixY[i - 1][j] + prefixY[i][j - 1] - prefixY[i - 1][j - 1];
                if (grid[i - 1][j - 1] == 'X') {
                    prefixX[i][j]++;
                } else if (grid[i - 1][j - 1] == 'Y') {
                    prefixY[i][j]++;
                }
            }
        }

        int count = 0;

        // 遍历所有从 (0,0) 到 (i,j) 的子矩阵
        for (int i2 = 1; i2 <= m; i2++) {
            for (int j2 = 1; j2 <= n; j2++) {
                int xCount = prefixX[i2][j2];
                int yCount = prefixY[i2][j2];
                if (xCount == yCount && xCount > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
