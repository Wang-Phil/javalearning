package JavaEE.chapter10;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class NullPointer {
    public static void main(String[] args) {
        //空指针异常
        String name = null;
        System.out.println(name.length());
    }
}
