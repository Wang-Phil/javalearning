package JavaEE.chapter11.String01;

import java.util.Locale;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class StringMethod {
    public static void main(String[] args) {
        //equals函数，比较内容是否相同，区分大小写
        String a = "hello";
        String b = "hello";
        System.out.println(a.equals(b));

        //equalsIgnoreCase函数，比较内容是否相同，不区分大小写
        System.out.println(a.equalsIgnoreCase(b));

        //length函数，获取字符串的长度
        System.out.println(a.length());

        //indexOf函数，获取字符在字符串中第一次出现的索引，从0开始找，没有找就返回-1
        String str = "ashodba;hdoad;nihao";
        System.out.println(str.indexOf(';'));

        //lastIndexOf函数，获取字符在字符串最后一次出现的索引，从0开始找，没有找到就返回-1
        System.out.println(str.lastIndexOf(';'));

        //substring函数，截取指定范围字符串
        System.out.println(str.substring(0,7));

        //trim去除前后的空格,中间的不去除
        String str1 = " daho adhaof ahdoaf ";
        System.out.println(str1.trim());

        //charAt函数，获取某索引处的字符
        System.out.println(str1.charAt(4));

        //toUpperCase函数，转换成大写
        System.out.println(str1.toUpperCase());

        //toLowerCase函数，转换成小写
        System.out.println(str1.toLowerCase());

        //concat函数，字符串拼接
        System.out.println(str.concat(str1));

        //replace函数，字符串的替换,将原来字符串中的内容换成替换后的内容
        System.out.println(str.replace("nihao","hao"));

        //split函数，分割字符串，根据特定字符串进行分割，如果有特定字符，需要加转义字符/
        String poem  = "锄禾日当午，汗滴禾下土，谁知盘中餐，粒粒皆辛苦";
        String[] poem1 = poem.split("，");
        for(String x : poem1){
            System.out.println(x);
        }

        //compareTo，比较两个字符串的大小。
        System.out.println(str.compareTo(str1));

        //toCharArray，转换为字符数组
        char[] array = str.toCharArray();
        System.out.println(array);

        //format，格式匹配
        String name = "jack";
        char sex = '男';
        int age = 18;
        double score = 67.22;
        String formatStr = "我的姓名是%s，性别为%c,芳龄%d,本次考试成绩为%.2f";
        System.out.println(String.format(formatStr, name,sex,age,score));
    }
}
