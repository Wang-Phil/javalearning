package JavaEE.chatper16.Socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @auther wangweicheng
 * 字节流的服务端和客户端进行交互
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //1、监听9999端口号，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        //2、没有客户端连接9999端口，程序会阻塞
        Socket socket = serverSocket.accept();
        System.out.println("服务端socket："+socket.getClass());
        //3、通过socket.getInputStream,读取客户端写入到数据通道的数据，并进行显示
        InputStream inputStream = socket.getInputStream();
        //4、IO读取,使用字符流，采用InputStreamReader将InputStream转换成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //5、使用字符流输出信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //6、通过输出流，写到socket当中
        bufferedWriter.write("hello world ,字符流");
        bufferedWriter.newLine();   //插入换行符表示结束
        bufferedWriter.flush(); //需要手动flush写入socket当中
        socket.shutdownOutput();
        //7、关闭流
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();

    }
}
