package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/11
 *@Time: 9:49
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。

你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */

public class Leetcode415 {
    public static void main(String[] args) {

    }
    //字符串相加
    public String addStrings(String num1, String num2) {
        //双指针进行模拟
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? char1[i] - '0' : 0;
            int b = j >= 0 ? char2[j] - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--; j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
