package JavaEE.chapter15.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Properties_ {
    public static void main(String[] args) throws IOException {
        //读取文件，mysql.properties文件，得到ip，user，pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String readLine;
        while((readLine = br.readLine() )!= null){
            String str[] = readLine.split("=");
            System.out.println(str[0]+":"+str[1]);
        }
    }


}
