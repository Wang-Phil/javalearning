package JavaEE.chapter15.filewrite;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class FileWriteStream01 {
    public static void main(String[] args) {

    }
    @Test
    public void fileWrite01() throws IOException{
        String dest = "风雨之后，定见彩虹";
        String filePath = "d:\\test.txt";
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(dest);                                 //写入字符串
        fileWriter.write(dest.toCharArray());                   //转换为字符数组写入
        fileWriter.write(dest.toCharArray(),0,4);       //从0开始写入字符
        fileWriter.close(); //close 等价于 flush() + 关闭,执行close的时候底层才执行写文件的操作

    }
}
