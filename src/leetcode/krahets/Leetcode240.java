package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/2
 *@Time: 14:11
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
 */

public class Leetcode240 {
    public static void main(String[] args) {

    }
    //搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n  -1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }else if(matrix[x][y] < target){
                x++;    //这一行元素全部小于target
            }else{
                y--;   //这一列元素全部大于target
            }
        }
        return false;
    }
}
