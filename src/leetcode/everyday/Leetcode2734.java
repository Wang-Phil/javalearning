package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/27
 *@Time: 10:27
 * 给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为：

选择 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。例如，'b' 用 'a' 替换，'a' 用 'z' 替换。
返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。

子字符串 是字符串中的一个连续字符序列。

现有长度相同的两个字符串 x 和 字符串 y ，在满足 x[i] != y[i] 的第一个位置 i 上，如果  x[i] 在字母表中先于 y[i] 出现，则认为字符串 x 比字符串 y 字典序更小 。
 */

public class Leetcode2734 {
    public static void main(String[] args) {

    }
    //执行子串操作后的字典序最小字符串
    public String smallestString(String s) {
        char chars[] = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] > 'a'){
                for(int j = i; j < chars.length && chars[j] > 'a'; j++){
                    chars[j] = (char) ((chars[j] - 'a' + 25) % 26 + 'a');
                }
                return String.valueOf(chars);
            }
        }
        chars[chars.length - 1] = 'z';
        return new String(chars);
    }
}
