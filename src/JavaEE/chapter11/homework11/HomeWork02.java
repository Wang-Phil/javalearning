package JavaEE.chapter11.homework11;

import java.util.Locale;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork02 {
    public static void main(String[] args) {
        String name = "Han shun Ping";
        strchange(name);
    }
    public static void strchange(String str){
        if(str == null){
            System.out.println("输入的名字为空，请重新输入");
        }
        String[] strings = str.split(" ");
        if(!(strings.length == 3)){
            System.out.println("输入的名字长度有问题");
        }
        String format = String.format("%s, %s.%c",strings[2],strings[0],strings[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
