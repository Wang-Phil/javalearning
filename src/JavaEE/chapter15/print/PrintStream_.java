package JavaEE.chapter15.print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //默认情况下，输出数据的位置是标准输出，就是显示器
        out.println("hack,hello");
        //因为print 底层使用的是write , 所以我们可以直接调用write 进行打印/输出
        out.write("你好".getBytes());
        out.close();
        //我们可以去修改打印流输出的位置/设备
        System.setOut(new PrintStream("d:\\text1.txt"));
        System.out.println("hello, 你好哇");
        System.out.close();

        PrintWriter pw = new PrintWriter(System.out);   //这里是在显示屏中输出
        pw.print("hi,这里是PrintWriter");
        pw.close();
        PrintWriter pw1 = new PrintWriter(new FileWriter("d:\\text1.txt"));     //这里是在文件中输出
        pw1.println("hi，这里是PrintWriter");
        pw1.close();
    }
}
