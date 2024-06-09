package leetcode.competiton401;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/9
 *@Time: 10:31
 * 给你两个 正整数 n 和 k。有 n 个编号从 0 到 n - 1 的孩子按顺序从左到右站成一队。

最初，编号为 0 的孩子拿着一个球，并且向右传球。每过一秒，拿着球的孩子就会将球传给他旁边的孩子。一旦球到达队列的 任一端 ，即编号为 0 的孩子或编号为 n - 1 的孩子处，传球方向就会 反转 。

返回 k 秒后接到球的孩子的编号。
 */

public class Leetcode100325 {
    public static void main(String[] args) {
        System.out.println(numberOfChild(3,3));
    }
    //找出k秒后拿着球的孩子
    public static int numberOfChild(int n, int k) {
        int sum = 2 * n - 2;
        k = k % sum;
        if(k < n) return k;
        else{
            return 2 * n - 2 - k;
        }
    }
}
