package JavaEE.chapter14.threaduse;

/**
 * @version 1.0
 * @auther wangweicheng
 */
//多线程实现
public class Thread03 {
    public static void main(String[] args) {
        //两个线程共享一个T1资源
        Thread thread1 = new Thread(new T1());
        Thread thread2 = new Thread(new T1());
        thread1.start();
        thread2.start();
    }
}

class T1 implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("T1:hello world"+(++count));
            if(count > 5) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class T2 implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("T2:yes, I am the world"+(++count));
            if(count > 5) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

