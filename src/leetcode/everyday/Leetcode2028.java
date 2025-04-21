package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/27
 *@Time: 10:17
 */

import java.util.Arrays;

public class Leetcode2028 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingRolls(new int[]{1, 2, 3, 4}, 3, 4)));
    }
    //找出缺失的观测数据
    public static  int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        int allsum = (len+n)*mean;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += rolls[i];
        }
        //首先判断不满足的情况
        if((float)(allsum - sum)/n > 6.0 || (float)(allsum - sum)/n < 1.0){
            return new int[0];
        }
        //接下来就是可以组成的，如何组合
        int avg = (allsum - sum)/n;
        int extra = (allsum - sum) % n;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = avg + (i < extra ? 1 : 0);
        }
        return res;
    }
}
