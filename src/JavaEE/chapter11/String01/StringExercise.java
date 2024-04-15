package JavaEE.chapter11.String01;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class StringExercise {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";
        String c = a + b;       //这里创建了三个对象
        String d = "helloabc";
        //总结，如果是常量相加，指向的是常量池中的数据，如果是变量相加指向的是堆中的数据
        System.out.println(c.intern() == d);

    }
}
