package JavaEE.chapter14.homework;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork02 {
    public static void main(String[] args) {
        Card card = new Card();
        Thread thread1 = new Thread(card);
        Thread thread2 = new Thread(card);
        thread1.setName("用户1");
        thread2.setName("用户2");
        thread1.start();
        thread2.start();
    }
}

class Card implements Runnable{
    private int count = 10000;

    @Override
    public  void run() {
        while(true){
            if(count <= 0){
                System.out.println("余额不足！");
                break;
            }
            synchronized (this){
                count -= 1000;
                System.out.println(Thread.currentThread().getName() +"取了1000元;" + "当前余额为："+count);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
