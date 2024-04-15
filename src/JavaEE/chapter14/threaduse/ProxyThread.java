package JavaEE.chapter14.threaduse;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ProxyThread {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new FinalImpl());
        proxy.send("proxy test()");
    }
}

//1、定义一个接口类
interface SmsService {
    void send(String message);
}

//2、创建一个代理类，实现这个接口
class Proxy implements SmsService {
    SmsService smsService = null;
    public Proxy(SmsService smsService) {
        this.smsService = smsService;
    }
    @Override
    public void send(String message) {
        System.out.println("代理类实现了send方法");
        smsService.send(message);
        System.out.println("代理类结束了send方法");
    }
}

//3、目标类实现接口类
class FinalImpl implements SmsService{

    @Override
    public void send(String message) {
        System.out.println("代理类测试"+message);
    }
}
