package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/22
 *@Time: 13:16
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */

import java.util.Arrays;

public class Leetcode73 {
    public static void main(String[] args) {

    }

    /*//矩阵置零算法，空间复杂度的逐步优化过程，从O(MN)到O(m+n），再到常量级别的空间复杂度
    public void setZeroes(int[][] matrix) {
        //如果是O（MN）的空间复杂度，就是复制一份数组，从那份数组进行遍历，如果遇到0就将matrix的每行和每列置为0
        int m = matrix.length;
        int n = matrix[0].length;
        int copy[][] = new int[m][n];
        //首先复制一份数组
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        //然后遍历这个复制的数组
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(copy[i][j] == 0){//如果这个数字为0，就将这一行和一列都置为0
                    for(int k = 0; k < m; k++){
                        matrix[k][j] = 0;
                    }
                    for(int k = 0; k < n; k++){
                        matrix[i][k] = 0;
                    }
                }
            }
        }
    }*/

/*    //采用两个一维数组，可以把空间复杂度降为O（m+n)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        //因为矩阵初始化为0，所以需要用1进行填充
        Arrays.fill(row,1);
        Arrays.fill(col,1);
        //首先找到有0的地方，存储在这两个一维数组中
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        //然后再遍历这两个一维数组，将矩阵对应的行和列置为0
        for(int i = 0; i < m; i++) {
            if(row[i] == 0) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < n; j++) {
            if(col[j] == 0) {
                for(int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }*/

    //数组本身的第一行和第一列可以作为存储是否为0，再用两个变量来保存第一行和第一列是否存在0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col = 0;
        int row = 0;
        //先保存0的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){//如果出现了0，进行判断
                    if(i == 0)  row = 1;        //第一行出现了0
                    if(j == 0)  col = 1;        //第一列出现了0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //然后再将矩阵置为0，注意这里的下标是从1开始的
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //只要有一个为0，就将该行或者该列全部置为0
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //再根据之前第一行和第一列保存的数字，置为0
        if(row == 1){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if(col == 1){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
