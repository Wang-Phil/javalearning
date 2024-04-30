package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/29
 *@Time: 10:00
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 */

import java.util.*;

public class Leetcode1329 {
    public static void main(String[] args) {
        System.out.println(diagonalSort(new int[][]{{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}}));
    }
    //对矩阵的对角线进行排序
/*    public static int[][] diagonalSort(int[][] mat) {
        //先取值，然后排序，然后再赋值
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < mat[0].length; i++){
            int j = 0;
            int a = i;
            while(a  < mat[0].length && j < mat.length){
                list.add(mat[j][a]);
                a++;
                j++;
            }
            Collections.sort(list);
            j = 0;
            a = i;
            while(a  < mat[0].length && j < mat.length){
                mat[j][a] = list.get(j);
                a++;
                j++;
            }
            list.clear();
        }
        for(int i = 1; i < mat.length; i++){
            int j = 0;
            int a = i;
            while(j  < mat[0].length && a < mat.length){
                list.add(mat[a][j]);
                a++;
                j++;
            }
            Collections.sort(list);
            j = 0;
            a = i;
            while(j  < mat[0].length && a < mat.length){
                mat[a][j] = list.get(j);
                a++;
                j++;
            }
            list.clear();
        }
        System.out.println(Arrays.deepToString(mat));
        return mat;
    }*/

    //自己写的太复杂，参考一下灵神的
    public static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] a = new int[Math.min(m, n)];
        for (int k = 1 - n; k < m; k++) { // k = i - j
            int leftI = Math.max(k, 0);
            int rightI = Math.min(k + n, m);
            for (int i = leftI; i < rightI; i++) {
                a[i - leftI] = mat[i][i - k];
            }
            Arrays.sort(a, 0, rightI - leftI);
            for (int i = leftI; i < rightI; i++) {
                mat[i][i - k] = a[i - leftI];
            }
        }
        return mat;
    }
}
