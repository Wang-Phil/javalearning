package JavaEE.chapter15.bufferedReadandWriter;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class BufferedReaderAndWriter {
    public static void main(String[] args) {

    }
    @Test
    //BufferedReader和BufferedWriter是安装字符操作，不能操作二进制文件[声音、视频、doc，pdf等等]，可能造成文件损坏
    public void ReaderAndWriter() throws IOException{
        String filePath = "d:\\FileReadStream01.java";
        //创建bufferedReader,里面要传一个与源文件直接相关的节点流
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;        //可以直接按行读取，效率较高
        while((line = br.readLine()) != null){  //readLine不会读取换行符
            System.out.println(line);
        }
        //关闭流只需要关闭外层流即可，底层会自动关闭节点流
        br.close();

        String writePath = "d:\\test.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(writePath));
        bw.write("hello, how are you");
        bw.newLine();       //换行
        bw.write("hello2,how old are you");
        bw.close();     //底层自动关闭FileWriter
    }
}
