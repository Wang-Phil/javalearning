package JavaEE.chapter17;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/17
 *Time: 14:41
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1、使用Properties类读取配置信息
        Properties prop = new Properties();
        prop.load(new FileInputStream("src\\re.properties"));
        String classfullpath = prop.getProperty("classfullpath");
        String methodName = prop.getProperty("method");


        //2、使用反射机制
        //（1）加载类，返回class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //(2)通过getInstance得到加载类的实例对象
        Object o = cls.newInstance();
        //（3）通过cls获得得到类的方法对象
        Method method1 = cls.getMethod(methodName);
        System.out.println("=====================");
        //（4）调用方法 传统方法为对象.方法(), 反射机制 方法.invoke(对象）
        method1.invoke(o);


        //java.lang.reflect.Field 代表类的成员变量，Field对象表示某个类的成员变量
        Field nameField = cls.getField("age");      //不能获取到私有的变量
        System.out.println(nameField.get(o));   //传统写法对象.成员变量, 反射: 成员变量对象.get(对象)

        //java.lang.constructor 代表类的构造方法，Constructor对象表示构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);

        Constructor constructor2 = cls.getConstructor(String.class);
        System.out.println(constructor2);
    }
}
