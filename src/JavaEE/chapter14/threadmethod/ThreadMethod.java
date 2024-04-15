package JavaEE.chapter14.threadmethod;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("ThreadMethod");
        t.start();
        t.setPriority(1);
        Thread.sleep(5000);
        t.interrupt();      //中断休眠
        System.out.println("main:"+Thread.currentThread().getName());
        System.out.println(t.getName()+"的优先级为"+t.getPriority());

    }
}

class T extends Thread{
    @Override
    public void run() {
        while(true){
            for (int i = 0; i < 10; i++) {
                System.out.println("数数："+i);
            }
            //休眠
            try {
                System.out.println(Thread.currentThread().getName()+"休眠中！");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"被中断了");
            }
        }
    }
}
