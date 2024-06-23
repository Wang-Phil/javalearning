package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/22
 *@Time: 20:41
 * 如果一个字符串满足以下条件，则称其为 美丽字符串 ：

它由英语小写字母表的前 k 个字母组成。
它不包含任何长度为 2 或更长的回文子字符串。
给你一个长度为 n 的美丽字符串 s 和一个正整数 k 。

请你找出并返回一个长度为 n 的美丽字符串，该字符串还满足：在字典序大于 s 的所有美丽字符串中字典序最小。如果不存在这样的字符串，则返回一个空字符串。

对于长度相同的两个字符串 a 和 b ，如果字符串 a 在与字符串 b 不同的第一个位置上的字符字典序更大，则字符串 a 的字典序大于字符串 b 。

例如，"abcd" 的字典序比 "abcc" 更大，因为在不同的第一个位置（第四个字符）上 d 的字典序大于 c 。
 */

public class Leetcode2663 {
    public static void main(String[] args) {

    }
    //字典序最小的美丽字符串
    public String smallestBeautifulString(String s, int k) {
        //字典序最小的美丽字符串
        //只要不包含，长度为2或者3的回文串，就不会包含更长的回文串
        //从后往前加，这样可以找到最小
        //加了之后需要判断进位
        //进位了之后需要判断是否构成了回文串，如果构成了回文串，后面的需要加
        //如果i == 0，并且还需要进位的时候，就是无效的字符串
        int n = s.length();
        int i = n - 1;
        k += 'a';
        char ch[] = s.toCharArray();
        ch[i]++;        //最后面先进位
        while(i < n) {   //先往回走，最后面会有++操作，最后肯定会跳出循环
            if (ch[i] == k) {
                if (i == 0) { //如果已经到头了，还要进位，就说明不符合了
                    return "";
                }
                ch[i] = 'a';
                ch[--i]++;
            } else if (i > 0 && ch[i] == ch[i - 1] || i > 1 && ch[i] == ch[i - 2]) {//如果存在回文串，
                ch[i]++;    //增加ch[i]
            } else {//继续往回比较
                i++;
            }
        }
        return new String(ch);
    }

}
