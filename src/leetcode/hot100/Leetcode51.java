package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/8
 *@Time: 11:05
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode51 {
    public static void main(String[] args) {

    }
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        //初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0);
        return ans;
    }
    public void backtrack(char[][] board, int row) {
        if(row == board.length) {
            ans.add(charToList(board));
            return;
        }
        for(int col = 0; col < board.length; col++) {
            if(isVaild(board, row, col)){
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public List<String> charToList(char [][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
           res.add(String.valueOf(row));
        }
        return res;
    }

    public boolean isVaild(char[][] board, int row, int col) {
        //判断同一列是否存在皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //判断45度角是否存在皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //判断135度角是否存在皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
