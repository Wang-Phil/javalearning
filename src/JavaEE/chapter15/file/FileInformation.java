package JavaEE.chapter15.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @version 1.0
 * @auther wangweicheng
 * 获取文件的相关信息
 */
public class FileInformation {
    public static void main(String[] args) {

    }
    @Test
    public void info(){
        //先创建文件对象
        File file = new File("d:\\new1.txt");
        //调用对应的方法，获取相关信息
        System.out.println("文件名字="+file.getName());
        System.out.println("文件的绝对路径="+file.getAbsolutePath());
        System.out.println("文件父级目录="+file.getParent());
        System.out.println("文件大小（字节）="+file.length());
        System.out.println("文件是否存在="+file.exists());
        System.out.println("是不是一个文件="+file.isFile());
        //目录本质也是一个文件，一种特殊的文件
        System.out.println("是不是一个目录="+file.isDirectory());
    }
}
