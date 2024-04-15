package JavaEE.chapter14.threaduse;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class SellTicket {
    public static void main(String[] args) {
        //三个线程实现售票窗口售票100
        Sell1 sell1 = new Sell1();
        Sell1 sell2 = new Sell1();
        Sell1 sell3 = new Sell1();
        sell1.start();
        sell2.start();
        sell3.start();
    }
}

class Sell1 extends Thread{
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
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口"+Thread.currentThread().getName()+"售出一张票"+
                    "剩余票数"+ --ticketSum);
        }
    }
}


