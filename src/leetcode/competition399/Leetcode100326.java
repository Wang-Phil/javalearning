package leetcode.competition399;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/26
 *@Time: 10:36
 * 给你一个字符串 word，请你使用以下算法进行压缩：
从空字符串 comp 开始。当 word 不为空 时，执行以下操作：
移除 word 的最长单字符前缀，该前缀由单一字符 c 重复多次组成，且该前缀长度 最多 为 9 。
将前缀的长度和字符 c 追加到 comp 。
返回字符串 comp 。
 */

public class Leetcode100326 {
    public static void main(String[] args) {
        System.out.println(compressedString("aaaaaaaaaaaaaabbccccccccccccccccccccccccccccccccccccc"));
    }
    //压缩字符串3
    public static String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int index = 0;
        while (index < word.length()) {
            char c = word.charAt(index);
            while(index + 1 < word.length() && word.charAt(index) == word.charAt(index + 1) && count < 9) {
                count++;
                index++;
            }
            sb.append(count);
            count = 1;
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
}
