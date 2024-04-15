package JavaEE.chapter15.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @version 1.0
 * @auther wangweicheng
 * 演示FileInputStream的使用
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void readFile01(){//读取一个字节
        String filePath = "d:\\test.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //read，读取一个字节，直到-1结束
            while((readData = fileInputStream.read()) != -1){
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭文件流，释放资源,文件流是一种资源，需要主动关闭
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readFile02(){//读取多个字节
        String filePath = "d:\\test.txt";
        byte readData[] = new byte[16];     //一次读取16个字节
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //read(byte),返回实际读取的字符数
            while(((readLen = fileInputStream.read(readData)) != -1)){
                System.out.println(new String(readData, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭文件流，释放资源,文件流是一种资源，需要主动关闭
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
