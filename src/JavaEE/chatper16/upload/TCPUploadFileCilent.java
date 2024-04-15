package JavaEE.chatper16.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TCPUploadFileCilent {
    public static void main(String[] args) throws Exception {
        //三个过程
        //1、从文件中读取图片转换为字节流
        //1.1建立与服务端的连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("socket:"+socket.getClass());
        //1.2从磁盘中读取对应文件,并转换为字节流
        String filePath = "D:\\1.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte bytes[] = StreamUtils.streamToByteArray(bis);
        //2、将字节流写入socket当中
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);       //写入数据通道
        bis.close();
        socket.shutdownOutput();        //设置结束标记

        //3、获取服务端传过来的消息，结束
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭资源
        bos.close();
        inputStream.close();
        socket.close();

    }
}
