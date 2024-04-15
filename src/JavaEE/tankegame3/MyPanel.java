package JavaEE.tankegame3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @version 1.0
 * @auther wangweicheng
 */
//为了监听键盘事件，需要实现keyListenter
//为了让Panel不停的绘制子弹，需要将MyPanel做成线程
public class MyPanel extends JPanel implements KeyListener,Runnable{
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel(){
        hero = new Hero(100, 100);  //初始化自己的坦克
        hero.setSpeed(5);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(100*(i+1), 0, 2, 1));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        //画出自己的坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        //画出hero发射的子弹
        if(hero.shot != null && hero.shot.isLive){
            System.out.println("子弹被绘制");
            g.draw3DRect(hero.shot.x, hero.shot.y, 2, 2, false);

        }

        //画出敌人的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
        }
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
            case 0://敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1://我的坦克
                g.setColor(Color.YELLOW);
                break;
        }
        //根据坦克方向，来绘制对应形状的坦克
        switch (direct){
            //direct：表示方向：{0：向上，1 向右，2向下，3，向左）
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上面轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y+20);//画出炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上面轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y+20);//画出炮筒
                break;

            default:
                System.out.println("暂时不处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //处理wasd，键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);      //设置坦克的方向为上
            hero.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);      //设置坦克的方向为右
            hero.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);      //设置坦克的方向为下
            hero.moveDown();
        } else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);      //设置坦克的方向为左
            hero.moveLeft();
        }

        if(e.getKeyCode() == KeyEvent.VK_J){
            System.out.println("用户按下了J,开始射击");
            hero.shotEnemyTank();
        }
        //重绘面板
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100ms，重绘区域，刷新绘图区域，实现动画效果
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
