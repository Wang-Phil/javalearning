package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/29
 *@Time: 10:03
 * 给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
 */

public class Leetcode2710 {
    public static void main(String[] args) {

    }
    //移除字符串中的尾随零
    public String removeTrailingZeros(String num) {
        int n = num.length();
        int i = n - 1;
        while(i >= 0 && num.charAt(i) == '0'){
            i--;
        }
        return num.substring(0,i+1);
    }
}
