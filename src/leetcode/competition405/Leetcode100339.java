package leetcode.competition405;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/7
 *@Time: 10:32
 * 给你一个字符串 s 和一个整数 k。请你使用以下算法加密字符串：

对于字符串 s 中的每个字符 c，用字符串中 c 后面的第 k 个字符替换 c（以循环方式）。
返回加密后的字符串。
 */

public class Leetcode100339 {
    public static void main(String[] args) {

    }
    //找出加密后的字符串
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char str[] = s.toCharArray();
        int len = str.length;
        for (int i = 0; i < str.length; i++) {
            sb.append(str[(i + k) % len]);
        }
        return sb.toString();
    }
}
