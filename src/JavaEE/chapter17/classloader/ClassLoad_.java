package JavaEE.chapter17.classloader;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 14:58
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassLoad_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字");
        String name = scanner.nextLine();
        switch (name){
            case "1"://静态加载，在编译的时候进行类的加载
                /*Dog dog = new Dog();
                dog.cry();*/
                break;
            case "2"://动态加载，在代码运行的时候才会进行加载该类，运行时，没有执行这段代码的话，就不会报错
                Class cls = Class.forName("Person");//得到类名
                Object o = cls.newInstance();//创建实例
                Method cry = cls.getMethod("cry");//得到方法
                cry.invoke(o);//使用方法
                break;
            default:
                System.out.println("do nothing");
        }
    }
}
