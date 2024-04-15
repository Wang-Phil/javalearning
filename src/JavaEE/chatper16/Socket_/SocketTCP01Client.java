package JavaEE.chatper16.Socket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //1、连接服务器，成功的话，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("socket:"+socket.getClass());
        //2、通过outputStream得到输出流
        OutputStream outputStream = socket.getOutputStream();
        //3、通过输出流，写到socket当中
        outputStream.write("hello,server".getBytes());
        //4、关闭对象
        outputStream.close();
        socket.close();
        //5、关闭完成
        System.out.println("客户端退出....");
    }
}
