package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/24
 *@Time: 10:40
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给定 n ，请计算 F(n) 。
 */

public class Leetcode509 {
    public static void main(String[] args) {

    }
    //斐波那契数列
    public int fib(int n) {
        if(n < 2)   return n;
        int f1 = 0, f2 = 1;
        int f3 = f1 + f2;
        int count = 2;
        while (count < n) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
            count++;
        }
        return f3;
    }
}
