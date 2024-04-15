package JavaEE.chapter13.drawpicture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class BallMove extends JFrame {
    Panels mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
    //构造器
    public BallMove(){
        mp = new Panels();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);//窗口可以监听键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
//画出小球，让它动起来
//KeyListener 监听器，监听键盘的事件
class Panels extends JPanel implements KeyListener {
    //为了让小球移动，设置x，y为小球的坐标
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);    //默认是黑色
    }
    //字符输出，触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //按键，会触发
    @Override
    public void keyPressed(KeyEvent e) {
        //根据用户按下不同的键，让小球让其移动
        //java中，会给每个键分配一个值
        if(e.getKeyCode() == KeyEvent.VK_DOWN){ //向下的箭头
            y++;        //向下移动
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x--;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x++;
        }
        //重新画一下面板，这样才能正常显示
        this.repaint();
    }
    //松键，会触发
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
