package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。
 * 给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
 * 返回这场比赛中将会成为冠军的队伍。
 */
public class Leetcode2923 {
    public static void main(String[] args) {
        System.out.println(findChampion(new int[][]{{0, 1}, {0, 0}}));
    }

/*
    public static int findChampion(int[][] grid) {
        //遍历二维数组,时间复杂度为O(n^2),可以改进
        int winer = 0;
        int max_Count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            int win_Count = 0;
            for (int j = 0; j < m; j++) {
                if(i != j && grid[i][j] == 1){
                    win_Count++;
                }
            }
            if(win_Count > max_Count){
                max_Count = win_Count;
                winer = i;
            }
        }
        return winer;
    }

 */

    public static int findChampion(int[][] grid) {
        //打擂台的方式，先假设winer是0，然后从第二行开始判断，如果grid[i][ans]是1的话，说明i可以击败ans，更新ans,时间复杂度为O(n)
        int ans = 0;
        for (int i = 1; i < grid.length; i++) {
            if(grid[i][ans] == 1){
                ans = i;
            }
        }
        return ans;
    }
}
