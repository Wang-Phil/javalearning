package JavaEE.chapter14.threaduse;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class SellTicketRunnable {
    public static void main(String[] args) {
        Sell2 sell2 = new Sell2();
        Thread thread = new Thread(sell2);
        Thread thread1 = new Thread(sell2);
        Thread thread2 = new Thread(sell2);
        thread.start();
        thread1.start();
        thread2.start();
    }
}
class Sell2 implements Runnable{
    private static int ticketSum = 100;     //多线程共享
    @Override
    public void run() {
        while(true){
            if(ticketSum <= 0){
                System.out.println("售票结束");
                break;
            }
            //休眠一下
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口"+Thread.currentThread().getName()+"售出一张票"+
                    "剩余票数"+ --ticketSum);
        }
    }
}