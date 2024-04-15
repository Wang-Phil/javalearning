package JavaEE.chapter14.threadexit;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        Thread.sleep(10000);    //主线程休息一下，再让子线程结束
        t.setLoop(false);       //终止线程
    }
}

class T extends Thread{
    private int count = 1;
    private boolean loop = true;

    //主线程调用set方法就可以终止线程
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
    @Override
    public void run() {
        while(loop){
            //休眠一下
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("数数:"+count++);
        }
    }
}