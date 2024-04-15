package JavaEE.chapter14.homework;



import javax.swing.*;
import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */

public class HomeWork01 extends JFrame {

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        t1.start();
        t2.start();
    }

}

class T1 extends Thread{
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while(loop){
            System.out.println("随机数字"+(int)(Math.random()*100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class T2 extends Thread{
    private T1 t1;
    private Scanner scanner = new Scanner(System.in);
    public T2(T1 t1) {
        this.t1 = t1;
    }
    @Override
    public void run() {
        //从键盘读取
        while(true){
            System.out.println("请输入你的指令");
            char key = scanner.next().toUpperCase().charAt(0);//记得回车
            System.out.println("输出key"+key);
            if(key == 'Q'){
                t1.setLoop(false);
                System.out.println("T2输入Q让t1结束");
                break;
            }
        }
    }
}