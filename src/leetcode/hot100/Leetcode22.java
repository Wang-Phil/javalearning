package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/8
 *@Time: 10:06
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 */

import java.util.LinkedList;
import java.util.List;

public class Leetcode22 {
    public static void main(String[] args) {

    }
    List<String> ans = new LinkedList<String>();
    StringBuilder str = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        //枚举左括号还是右括号
        backTracking(n,n);
        return ans;
    }
    public void backTracking(int left, int right){
        if(left == 0 && right == 0){        //循环结束
            ans.add(str.toString());
        }
        if(left > right) return;            //左括号的使用次数小于右括号，不匹配
        if(left > 0){            //先使用左括号
            str.append('(');
            backTracking(left - 1, right);
            str.deleteCharAt(str.length()-1);
        }
        if(right > 0){
            str.append(')');
            backTracking(left, right - 1);
            str.deleteCharAt(str.length()-1);
        }
    }
}
