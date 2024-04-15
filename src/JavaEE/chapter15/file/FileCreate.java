package JavaEE.chapter15.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @auther wangweicheng
 * 演示创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String pathname)
    public void create01() throws IOException {
        //两个斜杠是防止一个变成转义字符
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);     //这里file只是一个对象，并没有创建文件
        file.createNewFile();               //执行了createNewFile才会真正的，在磁盘创建文件
        System.out.println("创建文件成功！");
    }

    //方式2 new File(File parent, String child) 根据父目录文件+子路径构建
    public void create02() throws IOException {
        //两个斜杠是防止一个变成转义字符
        File parentFile = new File("d:\\");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);
        file.createNewFile();
        System.out.println("创建文件成功！");
    }

    //方式3：new File(String parent, String child) //根据父目录和子目录构建
    public void create03() throws IOException {
        //两个斜杠是防止一个变成转义字符
        String parentFile = "d:\\";
        String childName = "news3.txt";
        File file = new File(parentFile, childName);
        file.createNewFile();
        System.out.println("创建文件成功！");
    }

    //IO流的四个抽象类：InputStream, OutputStream, Reader, Writer
}
