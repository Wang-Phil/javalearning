package leetcode.CodeThinkdataStruct.datalist;

import java.util.Arrays;

public class Leetcode59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }

   static public int[][] generateMatrix(int n) {
        //螺旋矩阵
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int ans[][] = new int[n][n];
        int k = 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                ans[top][i] = k++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                ans[i][right] = k++;
            }
            right--;
            for(int i = right; i >= left; i--){
                ans[bottom][i] = k++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                ans[i][left] = k++;
            }
            left++;
        }
        return ans;
    }
}
