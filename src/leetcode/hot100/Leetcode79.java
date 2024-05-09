package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/8
 *@Time: 10:16
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */

public class Leetcode79 {
    public static void main(String[] args) {

    }
    //思路，从先搜索首字母相同的，然后往下递归
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)){
                    backTracking(board, word, i, j, 0);
                }
            }
        }
        return find;
    }

    public void backTracking(char[][] board, String word, int i, int j, int index) {
        //没找到或者越界了，返回
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return;
        if(index == word.length() - 1){
            find = true;
            return;
        }
        //必须回溯，因为要标记已经访问过的顶点，不然会有问题
        board[i][j] = '\0';
        backTracking(board, word, i + 1, j, index + 1);     //往下找
        backTracking(board, word, i - 1, j, index + 1);     //往上找
        backTracking(board, word, i, j - 1, index + 1);     //往左找
        backTracking(board, word, i, j + 1, index + 1);     //往右找
        board[i][j] = word.charAt(index);
    }

}
