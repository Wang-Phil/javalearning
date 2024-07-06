package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/5
 *@Time: 20:38
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
返回 你可以获得的最大乘积 。
 */

public class Leetcode343 {
    public static void main(String[] args) {}
    //整数拆分
    public int integerBreak(int n) {
        //整数拆分，数学证明
        if(n <= 3) return n-1;
        int a = n / 3; int b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a-1)*4;
        return (int)Math.pow(3, a)*2;
    }
}
