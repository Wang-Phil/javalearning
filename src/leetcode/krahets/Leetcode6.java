package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/13
 *@Time: 10:13
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
    //Z字形变换
    public  static String convert(String s, int numRows) {
        //二维数组进行模拟
        if(numRows==1) return s;
        int n = s.length();
        int m = numRows;
        char[][] arr = new char[m][n];
        char[] str = s.toCharArray();
        int k = 0;
        for(int j = 0; j < n && k < n; j++){
            //第一行和他的倍数行
            if(j % (numRows - 1) == 0){
                for(int i = 0; i < m; i++){
                    arr[i][j] = str[k++];
                    if(k == n) break;
                }
            }
            //其他行
            else{
                arr[m - 1- j % (m - 1)][j] = str[k++];
                if(k == n) break;
            }
        }
        //再次遍历二维数组组合成目标字符串
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != '\u0000')
                sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }

    //Z字形变换
    public  static String convert1(String s, int numRows) {
        //另外一种模拟方式
        if(numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for(char c : s.toCharArray()){
            list.get(i).append(c);
            if(i == 0 || i == numRows - 1){flag = -flag;}
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder stringBuilder : list){
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
}
