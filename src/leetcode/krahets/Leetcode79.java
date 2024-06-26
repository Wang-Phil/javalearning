package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/26
 *@Time: 20:55
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */

public class Leetcode79 {
    public static void main(String[] args) {

    }
    //单词搜索
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backTracking(board, word, i, j, 0);
                }
            }
        }
        return find;
    }
    private void backTracking(char[][] board,String word, int i, int j, int index) {
        //没找到直接return
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return;
        //找到了
        if(index == word.length() - 1){
            find = true;
            return;
        }
        board[i][j] = '\0';
        backTracking(board, word, i + 1, j, index + 1);
        backTracking(board, word, i - 1, j, index + 1);
        backTracking(board, word, i, j + 1, index + 1);
        backTracking(board, word, i, j - 1, index + 1);
        board[i][j] = word.charAt(index);
    }
}
