package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/23
 *@Time: 10:27
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3,4}, {5,6,7,8}, {9,10,11,12}}));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        //需要注意的是，每次遍历完一行或者一列之后，都需要去判断是否越过边界了。
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            if(++top > bottom) break;

            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            if(--right < left) break;

            for(int i = right; i >= left; i--){
                ans.add(matrix[bottom][i]);
            }
            if(--bottom < top) break;

            for (int i = bottom; i >= top; i--){
                ans.add(matrix[i][left]);
            }
            if(++left > right) break;
        }
        return ans;
    }
}
