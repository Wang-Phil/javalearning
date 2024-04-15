package JavaEE.chapter13.drawpicture;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class DrawExercise extends JFrame{
    //JFrame为一个画框
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawExercise();
        System.out.println("退出程序");
    }

    public DrawExercise(){//构造器
        mp = new MyPanel();     //初始化面板
        this.add(mp);           //把面板放入画框
        this.setSize(400, 300);     //设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击窗口关闭按钮，程序变为自动退出
        this.setVisible(true);  //可以显示
    }

}

class MyPanel extends JPanel{
    //JPanel就是一个画板
    //Graphics g 就是一个画笔，里面有很多方法用来画图
    public void paint(Graphics g){
        super.paint(g);     //调用父类方法完成初始化
        System.out.println("panit方法被调用了");
        g.drawOval(10,10,100,100);
    }


}
