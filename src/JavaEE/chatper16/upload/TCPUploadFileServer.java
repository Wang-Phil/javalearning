package JavaEE.chatper16.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TCPUploadFileServer {
    public static void main(String[] args) throws Exception {
        //三个过程
        //1、从socket中读取字符文件
        //1.1 监听端口，等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端等待连接。。。");
        Socket socket = serverSocket.accept();
        //1.2读取文件
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //2、将字符文件转换为字节流写入到文件当中，转变为图片
        byte bytes[] = StreamUtils.streamToByteArray(bis);
        String destFilePath = "D:\\成绩单不带说明1.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();
        //3、发消息到客户端图片完成传输，结束
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片了");
        bufferedWriter.flush();     //刷新到socket当中
        socket.shutdownOutput();        //设置结束标记

        //关闭资源
        bufferedWriter.close();
        bos.close();
        socket.close();
        serverSocket.close();
    }
}
