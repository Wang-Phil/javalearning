package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2684 {
    public static void main(String[] args) {

    }

    public static int maxMoves(int[][] grid) {
        //动态规划，后面的一种状态可以由前面的状态决定，第一列的初始状态为0
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        int max = 0;
        for (int i = 1; i < n; i++) {//i表示列
            for (int j = 0; j < m; j++) {
                for (int k = Math.max(j-1, 0); k < Math.max(j+1, m-1); k++) {
                    if(grid[j][i] > grid[k][i-1] && (dp[k][i-1] > 0 || i == 1)){
                        dp[j][i] = 1 + dp[k][i-1];
                        max = Math.max(max, dp[j][i]);
                    }
                }
            }
        }
        return max;
    }
}
