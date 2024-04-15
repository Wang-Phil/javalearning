package JavaEE.chapter14.threadmethod;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class MyDaemonThread {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);       //设置为守护线程，当除了这个线程之外的所有线程结束后，自动结束这个线程
        daemonThread.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println("主线程运行！");
        }
    }
}

class DaemonThread extends Thread{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("守护线程一直在守护着你！");
        }
    }
}

