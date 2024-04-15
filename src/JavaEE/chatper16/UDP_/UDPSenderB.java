package JavaEE.chatper16.UDP_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1、创建DatagramSocket对象，准备在9998端口发送数据
        DatagramSocket socket = new DatagramSocket(9998);
        //2、将需要发送的数据，封装到DatagramPacket对象当中
        byte[] data = "hello 明天吃火锅~".getBytes();
        //说明参数：需要封装的对象，对象的长度，主机IP，端口号
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(),9999);
        socket.send(datagramPacket);
        System.out.println("发送端B发送了数据给接收端A");
        //3、接收接收端发回来的信息
        byte[]  buf = new byte[1024];
        datagramPacket = new DatagramPacket(buf, buf.length);
        //有数据就会接收数据，没有数据就会等待
        socket.receive(datagramPacket);
        //进行拆包
        int lenth = datagramPacket.getLength();
        data = datagramPacket.getData();        //获取到数据
        System.out.println(datagramPacket);
        System.out.println(new String(data, 0, lenth));

        //关闭资源
        socket.close();
        System.out.println("B端退出");
    }
}
