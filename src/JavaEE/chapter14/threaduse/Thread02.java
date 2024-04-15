package JavaEE.chapter14.threaduse;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        //使用runnable实现线程
        Tiger tiger = new Tiger();
        Thread thread = new Thread(tiger);    //代理类thread替代tiger实现了run方法
        thread.start();         //代理模式实现线程。
    }
}

class animal{}
//单继承，无法继续继承实现Thread，这时候就可以使用代理模式
class Tiger extends animal implements Runnable{
    @Override
    public void run() {
        System.out.println("重写run方法，使用runnable实现线程");
    }
}
