package JavaEE.chapter13.drawpicture;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class GraphicsMethod extends JFrame {
    MyPanels mp = null;
    public static void main(String[] args) {
        new GraphicsMethod();
        System.out.println("程序结束");
    }

    public GraphicsMethod(){
        mp = new MyPanels();
        this.add(mp);
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanels extends JPanel{
    public void paint(Graphics g){
        super.paint(g);
        //画椭圆和圆
//        g.drawOval(10,10,300,400);
//        //画直线
//        g.drawLine(40,50,500,600);
//        //填充矩形
//        g.setColor(Color.blue);     //设置画笔颜色
//        g.fillRect(10,10,100,100);      //填充的话，就是填满，而不是只有边框
//        //填充椭圆
//        g.setColor(Color.red);
//        g.fillOval(20,20,400,300);
        //项目的根目录进行获取图片
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bp.jpg"));
//        g.drawImage(image,10,10,175,221,this);
        //写字
        g.setColor(Color.red);
        g.setFont(new Font("宋体",Font.BOLD, 50));
        g.drawString("北京你好",100, 100);
    }
}
