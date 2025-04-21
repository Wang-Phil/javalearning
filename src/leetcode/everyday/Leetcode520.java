package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/23
 *@Time: 20:59
 * 我们定义，在以下情况时，单词的大写用法是正确的：
全部字母都是大写，比如 "USA" 。
单词中所有字母都不是大写，比如 "leetcode" 。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 */

public class Leetcode520 {
    public static void main(String[] args) {

    }
    //检测大写字母
    public boolean detectCapitalUse(String word) {
        //太麻烦了，统计大写字母个数
        int cnt = 0;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                cnt++;
            }
        }
        return cnt == word.length() || cnt == 0 || cnt == 1 && Character.isUpperCase(word.charAt(0));

    }
}
