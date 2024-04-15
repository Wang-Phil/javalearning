package JavaEE.chapter11.String01;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class String1 {
    public static void main(String[] args) {
        String name = "jack";
        String s1 = new String("123");
        String s2 = new String(new char[]{'a','b','c','d'});
        String s3 = new String(new char[]{'a','b','c','d','e'},2,3);
        System.out.println(s3);
        //String类实现了结构Serializable，可以串行化，可以在网络上传输
        //同时还实现了Comparable接口，对象可以比较大小
        //string是final类，不可以被继承
        //String 有属性 private final char value[]，用于存放字符串内容
        //value是一个final类型，不可以修改（内容可以修改，地址不可以修改）
    }
}
