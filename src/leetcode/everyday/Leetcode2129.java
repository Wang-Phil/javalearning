package leetcode.everyday;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2129 {
    public static void main(String[] args) {
        String s = "L hV";
        System.out.println(capitalizeTitle(s));
    }
    @Test
    public static  String capitalizeTitle(String title) {
        //大小写变换
        //如果单词的长度为 1 或者 2 ，所有字母变成小写。
        //否则，将单词首字母大写，剩余字母变成小写。
        String[] lists = title.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String s : lists){
            if(!(ans.length() == 0)){
                ans.append(" ");
            }
            if(s.length() > 2){
                ans.append(s.substring(0,1).toUpperCase());
                s = s.substring(1);
            }
            ans.append(s.toLowerCase());
        }
        return ans.toString();
    }
}
