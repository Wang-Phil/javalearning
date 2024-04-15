package JavaEE.chapter14.synchronized_;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class SellTicketRunnable {
    public static void main(String[] args) {
        Sell3 sell3 = new Sell3();
        Thread thread = new Thread(sell3);
        Thread thread1 = new Thread(sell3);
        Thread thread2 = new Thread(sell3);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

//使用synchronized实现同步机制
class Sell3 implements Runnable{
    private static int ticketSum = 100;     //多线程共享
    private boolean loop = true;
    @Override
    public void run() {
        while(loop){
            sell();
        }
    }
    //public static synchronized void sell4(){} 静态方法的锁是加在SellTicketRunnable.class上的
    public static /*synchronized*/ void sell4(){//1、方法中加入synchronized实现同步
        synchronized (SellTicketRunnable.class){//2、代码块中加入synchronized实现同步，注意锁加在当前类
            System.out.println("sell4");
        }
    }

    Object object = new Object();
    //public synchronized void sell() 非静态方法同步方法，这时候锁在this中
    public /*synchronized*/ void sell(){//1、方法中加入synchronized实现同步
        synchronized (/*this*/ object){//2、代码块中加入synchronized实现同步,可以是this，也可以是其他对象
            if(ticketSum <= 0){
                loop = false;
                return;
            }
            System.out.println("窗口"+Thread.currentThread().getName()+"售出一张票"+
                    "剩余票数"+ --ticketSum);
        }

    }
}