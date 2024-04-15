package JavaEE.chapter15.fileread;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class FileReadStream01 {
    public static void main(String[] args) {

    }
    @Test
    public void FileRead01() throws IOException{
        String filePath = "d:\\test.txt";
        FileReader fileReader = new FileReader(filePath);
        int data;       //读取单个字符
//        while((data = fileReader.read()) != -1){
//            System.out.print((char)data);
//        }
        char read[] = new char[10]; //每次读取10个字符
        int readLen = 0;
        while((readLen = fileReader.read(read) )!= -1){
            System.out.println(new String(read));
        }
        fileReader.close();
    }
}
