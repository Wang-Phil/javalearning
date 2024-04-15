package JavaEE.chapter15.standard;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class InputAndOutput {
    public static void main(String[] args) {
        // System.in 类为： public final static InputStream in = null;
        //编译类型：InputStream
        //运行类型：BufferedInputStream
        //表示标准输入：键盘
        System.out.println(System.in.getClass());

        // System.in 类为： public final static PrintStream out = null;
        //编译类型：PrintStream
        //运行类型：PrintStream
        //表示标准输出：显示屏
        System.out.println(System.out.getClass());
    }
}
