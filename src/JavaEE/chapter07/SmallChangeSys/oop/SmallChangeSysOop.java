package JavaEE.chapter07.SmallChangeSys.oop;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能
 * 使用面向对象编程
 * 将各个功能对应一个方法
 */

public class SmallChangeSysOop {
    boolean loop = true;
    //1、零钱通菜单
    //2、零钱通明细，保存到数组或者对象或者string拼接
    //3、收益入账
    //获取键盘输入
    Scanner scanner = new Scanner(System.in);

    //2、零钱通明细，保存到数组或者对象或者string拼接
    String detail = "--------------零钱通明细----------------";

    //3、收益入账
    double money = 0;
    double balance = 0;
    Date data = null;  //表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //用于日期格式化

    //4、完成消费
    //加入新的变量，消费原因
    String reason = null;
    String choice = " ";
    //5、确认是否退出，输入的是否是y、n，进行确认是否退出
    //6、判断金额是否合理


    //显示菜单
    public void mainMenu(){
        do{
            System.out.println("============零钱通(OOP)=============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退      出");

            System.out.println("请选择(1-4):");
            String key = scanner.next();

            //使用switch
            switch (key){
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择！");
            }

        }while(loop);

    }

    //完成零钱通明细
    public void detail(){
        System.out.println(detail);
    }

    //完成收益入账
    public void income(){
        System.out.println("收益入账金额");
        money = scanner.nextDouble();
        //编程思想：找出不正确的跳出来就可以
        if(money <= 0){
            System.out.println("收益金额需要大于0");
            return; //退出方法
        }
        //校验是否合理
        balance += money;
        //拼接信息到明细当中
        data = new Date();      //获取当前日期
        detail += "\n收益入账\t" + money + "\t" + sdf.format(data) + "\t" + balance;
    }

    //完成消费
    public void pay(){
        System.out.println("消费金额");
        money = scanner.nextDouble();
        //校验是否合理，找出不正确的逻辑，然后退出
        if(money <= 0 || money > balance){
            System.out.println("收益金额需要应在0到"+balance);
            return;
        }
        balance -= money;
        System.out.println("消费原因说明：");
        reason = scanner.next();
        //拼接信息到明细当中
        data = new Date();      //获取当前日期
        detail += "\n" + reason + "\t-" + money + "\t" + sdf.format(data) + "\t" + balance;
    }

    //退出
    public void exit(){
        while(true){
            System.out.println("你确认要退出吗？ y/n");
            choice = scanner.next();
            if("y".equals(choice) || "n".equals(choice)) break;
        }
        //退出再进行判断
        if(choice.equals("y")) loop = false;
    }
}
