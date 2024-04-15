package JavaEE.chapter10;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class NumberFormatException {
    //默认抛出异常信息
    public static void main(String[] args) throws Exception{
        String name = "你好呀";
        int num = Integer.parseInt(name);
    }
}
