package JavaEE.chatper16;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本地InetAddress对象：getLocalHost
        InetAddress locolHost = InetAddress.getLocalHost();
        System.out.println(locolHost);

        //根据指定主机名/域名获取ip地址对象： getByName
        InetAddress host2 = InetAddress.getByName("DESKTOP-TNH49H9");
        System.out.println(host2);
        InetAddress host3 = InetAddress.getByName("www.baidu.com");
        System.out.println(host3);

        //获取InetAddress对象的主机名 getHostName
        String host3AName = host3.getHostName();
        System.out.println(host3AName);

        //获取InetAddress对象的地址 getHostAddress
        String host3Address = host3.getHostAddress();
        System.out.println(host3Address);
    }
}
