package JavaEE.tanke;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class MyPanel extends JPanel {
    Hero hero = null;
    public MyPanel(){
        hero = new Hero(100, 100);  //初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(hero.getX(), hero.getY(), g,0, 0);
    }

    //编写方法，画出坦克
    /**
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct 坦克方向（上下左右）
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type){
        //根据不同的坦克，设置不同的颜色
        switch (type){
            case 0://自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.YELLOW);
                break;
        }
        //根据坦克方向，来绘制坦克
        switch (direct){
            case 0:
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            default:
                System.out.println("暂时不处理");
        }
    }
}
