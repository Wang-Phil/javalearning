package JavaEE.chapter11.packageclass;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Integer01 {
    //演示int < -- > Integer 的装箱和拆箱
    //jdk5前是手动装箱和拆箱
    //手动装箱,int -> Integer
    int n1 = 100;
    Integer integer = new Integer(n1);
    Integer integer1 = Integer.valueOf(n1);
    //手动拆箱 Integer -> int
    int i = integer.intValue();

    //jdk5之后就是可以自动装箱和拆箱，底层还是原来的函数
    int n2 = 200;
    //自动装箱： int -> Integer
    Integer integer2 = n2;  //底层使用的是 Integer.valueOf(n2)方法
    //自动拆箱 Integer -> int
    int n3 = integer2;      //底层使用的是 intValue()方法
}
