package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/7
 *@Time: 15:14
 */

import java.util.LinkedList;
import java.util.List;

public class Leetcode17 {
    public static void main(String[] args) {

    }
    List<String> ans = new LinkedList<String>();
    StringBuilder str = new StringBuilder();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        backtrack(digits, 0);
        return ans;
    }

    public void backtrack(String digits, int index) {
        if(index == digits.length()) {
            ans.add(str.toString());
            return;
        }
        String letters = numString[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            str.append(letters.charAt(i));
            backtrack(digits, index + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
