package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/4
 *@Time: 9:42
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和
 */

public class Leetcode371 {
    public static void main(String[] args) {

    }
    //两整数之和
    public int getSum(int a, int b) {
        //位运算实现加法
        while(b != 0){
            int c = (a & b) << 1;       //c判断是否有进位
            a = a ^ b;                  //异或运算求非进位的和
            b = c;                      //b等于进位
        }
        return a;
    }
}
