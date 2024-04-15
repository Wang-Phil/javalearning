package JavaEE.chatper16.Socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @auther wangweicheng
 * 字节流的服务端和客户端进行交互
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //1、连接服务器，成功的话，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("socket:"+socket.getClass());
        //2、通过outputStream得到输出流
        OutputStream outputStream = socket.getOutputStream();
        //3、通过输出流，写到socket当中
        outputStream.write("hello,server".getBytes());
        //设置结束标记，关闭输出了
        socket.shutdownOutput();
        //4、IO读取
        InputStream inputStream = socket.getInputStream();
        byte[]  buf = new byte[1024];
        int readLine = 0;
        while((readLine = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0, readLine));
        }
        //5、关闭对象
        inputStream.close();
        outputStream.close();
        socket.close();
        //6、关闭完成
        System.out.println("客户端退出....");

    }
}
