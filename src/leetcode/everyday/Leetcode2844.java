package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/25
 *@Time: 10:15
 * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。

在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。

返回最少需要多少次操作可以使 num 变成特殊数字。

如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
 */

public class Leetcode2844 {
    public static void main(String[] args) {

    }
    //生成特殊数字的最少操作次数
    public int minimumOperations(String num) {
        int zero  = num.length() - (num.contains("0") ? 1 : 0);
        return  min(zero, find(num,"00"), find(num,"25"), find(num, "50"), find(num, "75"));
    }

    private int find(String num, String target) {
        int n = num.length();
        int i =  num.lastIndexOf(target.charAt(1));
        if(i <= 0) return n;
        int j = num.lastIndexOf(target.charAt(0), i-1);
        return j < 0 ? n : n - j - 2;
    }

    private int min(int x, int... y){
        for(int v : y){
            x = Math.min(x,v);
        }
        return x;
    }
}
