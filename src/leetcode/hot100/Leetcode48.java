package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/23
 *@Time: 11:01
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */

public class Leetcode48 {
    public static void main(String[] args) {

    }
    /*public void rotate(int[][] matrix) {
        //首先是申请一个二维数组，然后再根据找到的规律进行变换
        //找到规律，第i列变成第i行，第j行变成n-j-1列
        //这个不满足题意，因为题目要求是不要额外的空间，需要改进
        int n = matrix.length;
        int temp[][] = new int[n][];
        for(int i = 0; i < n; i++){//深拷贝
            temp[i] = matrix[i].clone();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[j][n-i-1] = temp[i][j];
            }
        }
    }*/
    //改进，对其进行循环旋转变换
    public void rotate(int[][] matrix) {
        //首先是申请一个二维数组，然后再根据找到的规律进行变换
        //找到规律，第i列变成第i行，第j行变成n-j-1列
        //AI好强大，都不用自己写，自己补充了
        int n = matrix.length;
        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
