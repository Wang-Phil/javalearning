package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/9
 *@Time: 10:12
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false
 */

public class Leetcode74 {
    public static void main(String[] args) {
        System.out.println(searchMatrix1(new int[][]{{0}}, 3));
    }
    //一次的二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        //思路：当然，因为将二维矩阵的行尾和行首连接，也具有单调性。我们可以将「二维矩阵」当做「一维矩阵」来做。
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n*m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid / n][mid % n] <= target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return matrix[left / n][left % n] == target;
    }

    //两次的二分查找
    public static boolean searchMatrix1(int[][] matrix, int target) {
        //思路：两次二分，第一次找到小于等于的那个行，第二次找到大于等于的那个列
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] <= target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        int row = left  - 1;
        //先排除一些特殊情况
        if(row < 0) return false;
        left = 0; right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] <= target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        int col = left - 1;
        return matrix[row][col] == target;
    }



}
