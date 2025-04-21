package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/18
 *@Time: 15:01
 * 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个 价格 。

例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。
给你一个字符串 sentence 表示一个句子和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。

返回表示修改后句子的字符串。

注意：所有价格 最多 为  10 位数字。
 */

public class Leetcode2288 {
    public static void main(String[] args) {
        System.out.println(discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
    }
    //价格减免
    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            double num = isPrice(word);
            if(isPrice(word) == -1) {
                sb.append(word).append(" ");
            }else{
                num = num * (100 - discount) / 100;
                String format = "%.2f"; // 保留两位小数
                sb.append("$" + String.format(format, num)).append(" ");
            }
        }
        return sb.toString().trim();
    }
    private static double isPrice(String word) {
        if(word.length() <= 1) return -1;
        if(word.charAt(0) != '$') return -1;
        char[] chars = word.toCharArray();
        double count = 0;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] < '0' || chars[i] > '9') return -1;
            count = (chars[i] - '0') + count * 10;
        }
        return count;
    }
}
