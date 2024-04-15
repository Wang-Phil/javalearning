package JavaEE.chapter14.threadmethod;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("hi"+i);
            if(i == 4){
//                t2.join();  //先让t2执行
                t2.yield();     //尝试先让t2先跑，不一定成功
            }
            Thread.sleep(100);
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("hello"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

