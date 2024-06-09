package JavaEE.chapter17.class_;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/17
 *Time: 16:37
 */

import JavaEE.chapter17.Cat;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、class也是类，继承了Object类
        //Class
        //2、Class对象不是new出来的，而是系统创建的
        //（1）传统new对象
        /*
         ClassLoader 类
         public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }*/
//        Cat cat = new Cat();
        //（2）反射方式
       /*
       ClassLoader 类, 仍然是通过ClassLoader 类加载Cat 类的Class 对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }*/
        //3、对于某个类的class对象，在内存中只有一份，类只加载一次
        Class cls1 = Class.forName("JavaEE.chapter17.Cat");
        Class cls2 = Class.forName("JavaEE.chapter17.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
    }
}
