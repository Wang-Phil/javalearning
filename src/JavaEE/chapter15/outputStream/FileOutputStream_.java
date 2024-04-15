package JavaEE.chapter15.outputStream;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void FileOutput01() throws IOException {
        //如果文件不存在，就会创建这个文件
        String filePath = "d:\\test.txt";
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(filePath);      //写入内容会覆盖原来的内容
//        fileOutputStream = new FileOutputStream(filePath,true);      //写入内容会增加到当前文件的末尾
        fileOutputStream.write('s');        //写一个字节
        String str = "hello, you are so beautiful";
        //str.getBytes() 可以将字符串转为字符数组
        fileOutputStream.write(str.getBytes());
        fileOutputStream.write(str.getBytes(), 0,3);        //off为偏移量，3为要写入的长度
        fileOutputStream.close();       //关闭文件流
    }
}


