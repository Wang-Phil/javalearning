package leetcode.competition396;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/5
 *@Time: 10:33
 * 有效单词 需要满足以下几个条件：
至少 包含 3 个字符。
由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
至少 包含一个 元音字母 。
至少 包含一个 辅音字母 。
* 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
注意：
'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
英文中的 辅音字母 是指那些除元音字母之外的字母。
* 1 <= word.length <= 20
word 由英文大写和小写字母、数字、'@'、'#' 和 '$' 组成。
 */

import kotlin.reflect.KVariance;

import java.util.HashSet;
import java.util.Set;

public class Leetcode100284 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isValid(new String("a3$e")));
    }

}

class Solution1 {
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3) return false;
        char[] chars = word.toCharArray();
        Set<Character> set = new HashSet<Character>();
        //set判断是否存在元音
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
        boolean haveYuanyin = false;
        boolean haveFuyin = false;
        boolean haveSpecial = false;
        for(int i = 0; i < n; i++) {
            //如果是字母类型，判断是否有元音和辅音
            if(chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') {
                if(set.contains(chars[i])) {
                    haveYuanyin = true;
                }
                else{
                    haveFuyin = true;
                }
            //不是字母类型，判断是否是特殊字符
            }else if(chars[i] == '@' || chars[i] == '#' || chars[i] == '$') {
                haveSpecial = true;
            }
        }
        return haveYuanyin && haveFuyin && !haveSpecial;
    }
}
