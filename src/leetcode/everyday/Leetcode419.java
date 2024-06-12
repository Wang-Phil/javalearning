package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/11
 *@Time: 9:06
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。

战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）
 */

public class Leetcode419 {
    public static void main(String[] args) {
        System.out.println(countBattleships2(new char[][]{{'X', '.', '.', 'X'}, {'.','.','.','X'},{'.','.','.','X'} }));
    }
    //甲板上的战舰
    static int visited[][];
    public  static int countBattleships(char[][] board) {
        //深度优先搜索
        int m = board.length;
        int n = board[0].length;
        visited = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && visited[i][j] == 0) {
                    dfs(i,j,board);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(int row, int col, char[][] board) {
        if(board[row][col] == 'X' && visited[row][col] == 0) {
            visited[row][col] = 1;
            if(row + 1 < board.length && visited[row + 1][col] == 0) {
                dfs(row+1,col,board);
            }
            if(col + 1 < board[0].length && visited[row][col+1] == 0) {
                dfs(row,col+1,board);
            }
        }
    }

    //另外一种思路：统计战舰的头部就可以，如果这个方格是头部分，那么这部分的左边和上边都不是战舰
    public static int countBattleships2(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'X' &&
                        (j == 0 || board[i][j-1] != 'X') &&
                        (i == 0 || board[i-1][j] != 'X')) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
