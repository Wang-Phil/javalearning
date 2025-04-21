package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/27
 *@Time: 22:05
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */

public class Leetcode50 {
    public static void main(String[] args) {

    }
    //Pow（x,n)
    public double myPow(double x, int n) {
        //矩阵快速幂,两种实现形式，一个是递归，一个是循环
        if(x == 0) return 0;
        if(n < 0){
            x = 1 / x;
            n = -n;
        }
        double res = 1;
        while(n != 0){
            if((n & 1) == 1){
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
