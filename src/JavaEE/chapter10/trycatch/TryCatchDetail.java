package JavaEE.chapter10.trycatch;

import java.sql.SQLOutput;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TryCatchDetail {
    public static void main(String[] args) {
        //快捷键 ctrl + alt + t
        //异常的快捷键
        try {
            String str = "你好";
            int a = Integer.parseInt(str);
            System.out.println("数字"+a);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("不管是否出现异常，都会运行");
        }
        System.out.println("程序继续。。。。");
    }
}
