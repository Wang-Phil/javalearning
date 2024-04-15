package JavaEE.chapter15.homework;

import java.io.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork01 {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\mytemp";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        String parent = "d:\\mytemp";
        String child = "hello.txt";
        File file1 = new File(parent, child);
        file1.createNewFile();
        if(file1.exists()){
            System.out.println("该文件已经存在，不需要重新创建");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
        bw.write("hello,world");
        bw.close();


    }
}
