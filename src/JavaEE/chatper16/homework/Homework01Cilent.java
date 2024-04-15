package JavaEE.chatper16.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Homework01Cilent {
    public static void main(String[] args) throws IOException {
        //1、连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost(), 9990);
        System.out.println("客户端与服务器连接");
        //2、通过outputStream得到输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("name");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        socket.shutdownOutput();
        //3、获取输入流，得到socket当中的数据
        InputStream inputStream  = socket.getInputStream();
        //将其转换为字符流编码
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //读取信息，并输出
        String s = bufferedReader.readLine();
        System.out.println(s);
        //4、关闭资源
        bufferedWriter.close();
        socket.close();


    }
}
