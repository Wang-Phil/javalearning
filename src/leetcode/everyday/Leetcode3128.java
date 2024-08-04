package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/8/2
 *@Time: 19:56
 * 给你一个二维 boolean 矩阵 grid 。

请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。

注意：

如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。
 */

import java.util.Arrays;

public class Leetcode3128 {
    public static void main(String[] args) {
        int grid[][] = {{1, 0, 1},{1 ,0 ,0},{1,0,0}};
        System.out.println(numberOfRightTriangles(grid));
    }
    //直角三角形
    public static long numberOfRightTriangles(int[][] grid) {
        //以二维数组的每一个坐标作为直角三角形的顶点，然后往下和往右延伸，找到直角。注意，三个元素不需要相邻。
        //暴力解法超时
        long ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    //往右的方向
                    for (int k = j+1; k < m; k++) {
                        if(grid[i][k] == 0) continue;
                        int len = k -j;
                        //往下的方向
                        for(int a = i+1; a < n; a++) if(grid[a][j] == 1) ans++;
                        //往上的方向
                        for(int a = i-1; a >= 0; a--) if(grid[a][j] == 1) ans++;
                    }
                    //往左的方向
                    for(int k = j-1; k >= 0; k--) {
                        if(grid[i][k] == 0) continue;
                        int len = j - k;
                        //往下的方向
                        for(int a = i+1; a < n; a++) if(grid[a][j] == 1) ans++;
                        //往上的方向
                        for(int a = i-1; a >= 0; a--) if(grid[a][j] == 1) ans++;
                    }
                }
            }
        }
        return ans;
    }


    public static long numberOfRightTriangles1(int[][] grid) {
        long ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        //统计每一列中元素为1的个数
        int colSum[] = new int[m];
        Arrays.fill(colSum,-1);
        for(int row[] : grid){
            for(int j = 0; j < m; j++){
                colSum[j] += row[j];
            }
        }
        //然后统计每一行的个数
        for(int row[] : grid){
            int rowSum = -1;
            for(int x : row){
                rowSum += x;
            }
            for(int i = 0; i < n; i++){
                if(row[i] == 1){
                    ans += rowSum*colSum[i];
                }
            }
        }
        return ans;
    }
}
