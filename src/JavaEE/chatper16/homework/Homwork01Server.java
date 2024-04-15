package JavaEE.chatper16.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Homwork01Server {
    public static void main(String[] args) throws IOException {
        //1、监听端口号
        ServerSocket serverSocket = new ServerSocket(9990);
        //2、等待连接
        Socket socket = serverSocket.accept();
        System.out.println("等待客户端连接");
        //3、获取输入流，得到socket当中的数据
        InputStream inputStream  = socket.getInputStream();
        //将其转换为字符流编码
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //读取信息，并输出
        String s = bufferedReader.readLine();
        System.out.println(s);
        //通过IO流输出信息到socket当中
        OutputStream outputStream =  socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        if(s.equals("name")){
            bufferedWriter.write("我是 xxx");
        }else if(s.equals("hobby")){
            bufferedWriter.write("编写java程序");
        }else{
            bufferedWriter.write("你说啥呢");
        }
        bufferedWriter.newLine();    //输入换行符表示结束
        bufferedWriter.flush();     //写入到socket当中
        socket.shutdownOutput();
        //4、关闭资源
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();

    }
}
