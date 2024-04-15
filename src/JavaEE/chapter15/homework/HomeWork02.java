package JavaEE.chapter15.homework;

import java.io.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork02 {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\test.txt";
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        int lineCount = 0;
        while((line = br.readLine()) != null){
            System.out.println("第"+(++lineCount)+"行为："+line);
        }
        br.close();
    }
}
