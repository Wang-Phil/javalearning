package JavaEE.chapter17.classloader;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 20:39
 */

public class ClassLoad03 {
    public static void main(String[] args) {
        System.out.println(B.num);      //直接使用类的静态属性，也会执行类加载过程
        /*
        * 1、加载B类，并生产B的class对象
        * 2、连接 num = 0
        * 初始化阶段
        * 依次收集类中的所有静态变量的赋值动作和静态代码块中的语句，并对其进行合并
        *
        clinit(){
            System.out.println("B 静态代码块被执行");
            num = 300;      //被后面的语句合并，这里不起作用，最后输出100
            num = 100;
        }
        * */
        new B();//加断点，追溯源码看是否有同步机制
        /*
        * protected Class<?> loadClass(String name, boolean resolve)
        *throws ClassNotFoundException{
            //正因为有这个机制，才能保证某个类在内存中, 只有一份Class 对象
            synchronized (getClassLoadingLock(name)) {
            //....
            }
        }
        *
        *
        * */
    }
}

class B{
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }
    static int num = 100;
//    public B(){
//        System.out.println("B 的构造器被执行");
//    }
}