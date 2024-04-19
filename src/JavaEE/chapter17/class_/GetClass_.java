package JavaEE.chapter17.class_;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/19
 *Time: 下午4:54
 */

import JavaEE.chapter17.Cat;

public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、Class.forName(),编译类的情况下，使用getclass,多用于配置文件的时候
        String classAllPath = "JavaEE.chapter17.Cat";       //通过读取文件配置获取
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2、类名.Class,加载类的情况下，用于参数传递
        Class<?> cls2 = Cat.class;
        System.out.println(cls2);

        //3、对象.getClass,运行的情况下，已经有对象实例，通过创建好的对象，获取Class对象
        Cat cat = new Cat();
        Class cls3 = cat.getClass();
        System.out.println(cls3);

        //4、通过类加载器【4种】获取类的Class对象
        //（1）先得到类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        //（2）通过类加载器获取到Class对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //5、基本数据类型(int,char,boolean,float,double,byte,long,short),可以通过.class方式获取到class类对象
        Class<Integer> intClass = int.class;
        Class<Character> charClass = char.class;
        System.out.println(intClass);
        System.out.println(charClass);

        //6、基本数据类型的包装类，可以通过.TYPE得到Class对象
        Class cls5 = Integer.TYPE;
        System.out.println(cls5);

    }
}
