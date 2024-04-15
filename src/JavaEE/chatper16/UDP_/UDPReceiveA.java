package JavaEE.chatper16.UDP_;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class UDPReceiveA {
    public static void main(String[] args) throws IOException {
        //1、创建DatagramSocket对象，准备在9999端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2、接收接收端发回来的信息
        byte[]  buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //有数据就会接收数据，没有数据就会等待
        System.out.println("接收端A等待接受B端数据");
        socket.receive(datagramPacket);
        System.out.println("接收端A接受到了B端数据的数据");
        //进行拆包
        int lenth = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();        //获取到数据
        System.out.println(datagramPacket);
        System.out.println(new String(data, 0, lenth));
        //3、将需要发送的数据，封装到DatagramPacket对象当中
        data = "好的，明天见".getBytes();
        //说明参数：需要封装的对象，对象的长度，主机IP，端口号
        datagramPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(),9998);
        socket.send(datagramPacket);

        //关闭资源
        socket.close();
        System.out.println("A端退出");

    }
}
