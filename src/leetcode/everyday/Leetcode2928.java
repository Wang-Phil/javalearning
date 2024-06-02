package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/1
 *@Time: 9:54
 * 给你两个正整数 n 和 limit 。

请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
 */

public class Leetcode2928 {

    public int distributeCandies1(int n, int limit) {
        if(n/3 > limit) return 0;
        int cnt = 0;
        int first = 0;
        int second = 0;
        for(int i = 0; i <= limit; i++){
            first = n - i ;
            for(int j = 0; j <= limit && first >= 0; j++){
                second = first - j;
                if(second >= 0 && second <= limit){
                    cnt++;
                }
            }
            first = 0;
            second = 0;
        }
        return cnt;
    }
    //给小朋友们分糖果
    public int distributeCandies(int n, int limit) {
        //容斥原理解题，数学方法
        //先计算所有方法数，然后减去不合理的方法
        return c2(n+2) - c2(n - limit +1) * 3 + c2(n - 2 * limit) * 3 - c2(n - 3 * limit - 1);
    }

    private int c2(int n){
        return n > 1 ? n *(n-1) /2 : 0;
    }
}
