package JavaEE.chapter17;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 22:12
 * 反射调用方法
 */

import JavaEE.chapter11.String01.String1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1. 得到Boss 类对应的Class 对象
        Class<?> bossCls = Class.forName("JavaEE.chapter17.Boss");
        //2. 创建对象
        Object o = bossCls.newInstance();
        //3. 调用public 的hi 方法
        //Method hi = bossCls.getMethod("hi", String.class);
        //3.1 得到hi 方法对象
        Method hi = bossCls.getDeclaredMethod("hi", String.class);
        //3.2调用方法
        hi.invoke(o,"大怪物");
        //4. 调用private static 方法
        //4.1 得到say 方法对象
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //4.2 因为say 方法是private, 所以需要暴破，原理和前面讲的构造器和属性一样
        say.setAccessible(true);
        System.out.println(say.invoke(o, 100, "张三", '男'));
        //4.3 因为say 方法是static 的，还可以这样调用，可以传入null
        System.out.println(say.invoke(null, 200, "李四", '女'));

        //5. 在反射中，如果方法有返回值，统一返回Object , 但是他运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型=" + reVal.getClass());//String
        System.out.println(reVal);

        //在演示一个返回的案例
        Method m1 = bossCls.getDeclaredMethod("m1");
        Object reVal2 = m1.invoke(o);
        System.out.println("reVal2 的运行类型=" + reVal2.getClass());//Monster
    }
}
class Monster {}
class Boss {//类
    public int age;
    private static String name;
    public Boss() {//构造器
    }
    public Monster m1() {
        return new Monster();
    }
    private static String say(int n, String s, char c) {//静态方法
        return n + " " + s + " " + c;
    }
    public void hi(String s) {//普通public 方法
        System.out.println("hi " + s);
    }
}