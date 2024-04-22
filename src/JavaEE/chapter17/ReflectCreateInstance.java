package JavaEE.chapter17;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 21:38
 * 使用反射创建对象的几种方式
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1、先得到Class对象
        Class<?> userCls = Class.forName("JavaEE.chapter17.User");
        //2、通过public的无参构造器
        Object o = userCls.getDeclaredConstructor().newInstance();
        System.out.println(o);
        //3、通过public的有参构造器
        //3.1先得到构造器
        Constructor<?> constructor = userCls.getConstructor(String.class);
        //3.2然后用构造器创建实例
        Object user1 = constructor.newInstance("user1");
        System.out.println(user1);
        //4、通过非公有的构造器创建实例
        //4.1先得到构造器
        Constructor<?> constructor2 = userCls.getDeclaredConstructor(int.class,String.class);
        //私有构造器，得先爆破，才能使用,暴破【暴力破解】, 使用反射可以访问private 构造器/方法/属性, 反射面前，都是纸老虎
        constructor2.setAccessible(true);
        //4.3然后用构造器创建实例
        Object user2 = constructor2.newInstance(200,"user2");
        System.out.println(user2);


    }
}

class User { //User 类
    private int age = 10;
    private String name = "名字";
    public User() {//无参public
    }
    public User(String name) {//public 的有参构造器
        this.name = name;
    }
    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}