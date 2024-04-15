package JavaEE.chatper16.Socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @auther wangweicheng
 * 字节流的服务端和客户端进行交互
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //1、连接服务器，成功的话，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("socket:"+socket.getClass());
        //2、通过outputStream得到输出流
        OutputStream outputStream = socket.getOutputStream();
        //3、通过字符流，写到socket当中
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server");
        bufferedWriter.newLine();       //插入换行符，表示结束
        bufferedWriter.flush();     //手动flush
        //设置结束标记，关闭输出了
        socket.shutdownOutput();
        //4、IO读取,采用字符流进行读取
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //5、关闭对象
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        //6、关闭完成
        System.out.println("客户端退出....");
    }
}
