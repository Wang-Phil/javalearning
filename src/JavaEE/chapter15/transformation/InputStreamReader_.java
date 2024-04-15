package JavaEE.chapter15.transformation;

import java.io.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class InputStreamReader_
{
    public static void main(String[] args) throws IOException {
        //InputStreamReader,可以将字节流转换为字符流，然后还可以指定编码，比较方便
        String filePath = "d:\\test.txt";
        //1、把FileInputStream转换为InputStreamReader
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //2、把InputStreamReader 传入 BufferedReader
        BufferedReader br = new BufferedReader(isr);
        //3、读取
        String s = br.readLine();
        System.out.println("读取内容："+s);
        br.close();

        //OutputStreamWriter,写文件,可以指定编码方式
        //1、创建流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
        //2、写入
        osw.write("hello,你好吗！");
        //3、关闭
        osw.close();
    }
}
