package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/28
 *@Time: 17:42
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
设置位
 的个数（也被称为汉明重量）。
 */

public class Leetcode191 {
    public static void main(String[] args) {

    }
    //位1的个数
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if((n & 1) == 1) count++;
            n >>>= 1;
        }
        return count;
    }
}
