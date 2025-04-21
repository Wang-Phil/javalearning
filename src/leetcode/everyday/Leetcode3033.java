package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/5
 *@Time: 20:34
 * 给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素
返回矩阵 answer 。
 */

public class Leetcode3033 {
    public static void main(String[] args) {

    }
    //修改矩阵
    public int[][] modifiedMatrix(int[][] matrix) {
        //遍历保存
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int max[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i] = Math.max(max[i], matrix[j][i]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] != -1){
                    res[i][j] = matrix[i][j];
                }else{
                    res[i][j] = max[j];
                }
            }
        }
        return res;
    }
}
