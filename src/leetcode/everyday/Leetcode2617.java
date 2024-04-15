package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2617 {
    public static void main(String[] args) {
        int grid[][] =  {{3,4,2,1},{4,2,3,1},{2,1,0,0},{2,4,0,0}};
        System.out.println(minimumVisitedCells(grid));
    }
    public static int minimumVisitedCells(int[][] grid) {
        //行数与列数
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--) {
                int k = grid[i][j];
                int min = 100001;
                for(int x = i+1; x <= i + k && x < m; x++){
                    min = Math.min(dp[x][j], min);
                }
                for(int x = j+1; x <= j + k && x < n; x++){
                    min = Math.min(dp[i][x], min);
                }
                if(min != 100001) dp[i][j] = min + 1;
            }
        }
        if(dp[0][0] == 0) return -1;
        return dp[0][0];
    }
}
