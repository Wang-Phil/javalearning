package leetcode.competition405;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/7
 *@Time: 10:35
 * 给你一个正整数 n。

如果一个二进制字符串 x 的所有长度为 2 的
子字符串
中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。

返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode100328 {
    public static void main(String[] args) {
        System.out.println(validStrings(18));
    }
    //生成不含相邻零的二进制字符串
    public static List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            result.add("0");
            result.add("1");
            return result;
        }
        generateStrings("", n, result);
        return result;
    }


    private static void generateStrings(String current, int n, List<String> result) {
        if (current.length() == n) {
            if (isValid(current)) {
                result.add(current);
            }
            return;
        }
        generateStrings(current + "0", n, result);
        generateStrings(current + "1", n, result);
    }

    private static boolean isValid(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '0') {
                return false;
            }
        }
        return true;
    }
}
