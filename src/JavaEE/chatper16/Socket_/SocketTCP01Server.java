package JavaEE.chatper16.Socket_;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class SocketTCP01Server {
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

        //5、关闭流
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
