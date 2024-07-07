package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/7
 *@Time: 9:21
 * 给你一个下标从 0 开始的 8 x 8 网格 board ，其中 board[r][c] 表示游戏棋盘上的格子 (r, c) 。棋盘上空格用 '.' 表示，白色格子用 'W' 表示，黑色格子用 'B' 表示。

游戏中每次操作步骤为：选择一个空格子，将它变成你正在执行的颜色（要么白色，要么黑色）。但是，合法 操作必须满足：涂色后这个格子是 好线段的一个端点 （好线段可以是水平的，竖直的或者是对角线）。

好线段 指的是一个包含 三个或者更多格子（包含端点格子）的线段，线段两个端点格子为 同一种颜色 ，且中间剩余格子的颜色都为 另一种颜色 （线段上不能有任何空格子）。你可以在下图找到好线段的例子：
 */

public class Leetcode1958 {
    public static void main(String[] args) {

    }
    //检查操作是否合法
    private static final int[][] dirs = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        //定义八个方向
        int m = board.length;
        int n = board[0].length;
        for(int dir[] : dirs){
            int x  = dir[0] + rMove;
            int y = dir[1] + cMove;
            if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != (color ^ 'W' ^ 'B')) continue;
            while(true){
                x += dir[0];
                y += dir[1];
                if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '.') break;
                if(board[x][y] == color) return true;
            }
        }
        return false;
    }
}
