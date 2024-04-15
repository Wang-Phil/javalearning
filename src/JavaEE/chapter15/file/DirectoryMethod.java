package JavaEE.chapter15.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @auther wangweicheng
 * 目录的创建和删除
 */
public class DirectoryMethod {
    public static void main(String[] args) {

    }
    @Test
    public void directoryMethod() throws IOException {
        String fileName1 = "d:\\new1.txt";      //删除文件
        File file = new File(fileName1);
        if(file.exists()){
            file.delete();
            System.out.println("文件已经删除"+(file.exists() == false));
        }

        String fileName2 = "d:\\demo02";        //删除空目录
        File file2 = new File(fileName2);
        if(file2.exists()){
            file2.delete();
            System.out.println("文件已经删除"+(file2.exists() == false));
        }
        else{
            System.out.println("文件不存在");
        }

        String fileName3 = "d:\\demo\\a\\b\\c"; //创建多级目录
        File file3 = new File(fileName3);
        if(file3.exists()){
            System.out.println("文件存在");
        }
        else{
            System.out.println("文件不存在，创建该文件");
            file3.mkdirs();
        }
    }
}


