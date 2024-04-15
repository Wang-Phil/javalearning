package JavaEE.chatper16.Socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @auther wangweicheng
 * 字节流的服务端和客户端进行交互
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //1、监听9999端口号，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        //2、没有客户端连接9999端口，程序会阻塞
        Socket socket = serverSocket.accept();
        System.out.println("服务端socket："+socket.getClass());
        //3、通过socket.getInputStream,读取客户端写入到数据通道的数据，并进行显示
        InputStream inputStream = socket.getInputStream();
        //4、IO读取
        byte[]  buf = new byte[1024];
        int readLine = 0;
        while((readLine = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0, readLine));
        }
        //5、通过outputStream得到输出流
        System.out.println("服务端写入信息");
        OutputStream outputStream = socket.getOutputStream();
        //6、通过输出流，写到socket当中
        outputStream.write("hello,client".getBytes());
        System.out.println("服务端写入信息");
        socket.shutdownOutput();
        //7、关闭流
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
