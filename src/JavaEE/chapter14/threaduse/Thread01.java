package JavaEE.chapter14.threaduse;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建cat对象，当做线程
        Cat cat = new Cat();
//        cat.run();          //这里只是一个普通的run方法，没有真正启动一个线程，把run方法执行完毕之后，才会继续执行
        cat.start();        //启动线程，线程自动调用run方法
        for (int i = 0; i < 80; i++) {
            Thread.sleep(1000);
            System.out.println("主线程="+ Thread.currentThread().getName());
        }

    }
}

//1.当一个类继承了Thread类，该类就是可以当做线程使用
//2、重写run方法，协商自己的业务代码
//3、run Thread 类实现了Runnable接口的run方法
/*
    @Override
        public void run() {
            if (target != null) {
                target.run();
            }
        }
 */
class Cat extends Thread {
    @Override
    public void run() { //重写run，
       //每隔一秒，输出“喵喵”
        //ctrl + alt + t,快捷键选择功能try，catch
        int times = 1;
        while (times < 80) {
            try {
                System.out.println("喵喵~~~~~~~"+times++ + "线程名为："+ Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
