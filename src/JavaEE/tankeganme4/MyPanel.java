package JavaEE.tankeganme4;

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
    Vector<Bomb> bombs = new Vector<>();        //炸弹
    int enemyTankSize = 3;

    //定义三张图片,用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    public MyPanel(){
        hero = new Hero(500, 600);  //初始化自己的坦克
        hero.setSpeed(5);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100*(i+1), 0, 2, 2);
            enemyTanks.add(enemyTank);
            //启动敌人坦克线程，让其动起来
            new Thread(enemyTank).start();
            //每创建一个敌人坦克，就初始化一个shot对象，并启动shot
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY()+ 60, 2);
            System.out.println("子弹方向为："+enemyTank.getDirect());
            //加入Vector中
            enemyTank.shots.add(shot);
            //启动 shot对象
            new Thread(shot).start();
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb3.png"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        //画出自己的坦克
        if(hero != null && hero.isLive){
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //画出hero发射的子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if(shot != null && shot.isLive){
                System.out.println("子弹被绘制");
                g.draw3DRect(shot.x, shot.y, 2, 2, false);
            }
            else{//无效，删除shots中的shots
                hero.shots.remove(shot);
            }
        }

        //如果bombs中有对象，就画出来
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            if(bomb.life > 6){
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            }else if(bomb.life > 3){
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            }else{
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让生命值减少
            bomb.lifeDown();
            //如果bomb.life为0，就从bombs集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }

        //画出敌人的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank.isLive){//敌人坦克是存活的，才画出来
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹，进行绘制
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive){
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    }
                    else{
                        enemyTank.shots.remove(shot);
                    }
                }
            }
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
    //如果可以发射多颗子弹，就需要将所有子弹与所有的坦克都要进行判断
    public void hitEnemyTank(){
        //遍历所有子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            //子弹还存活的话,遍历所有敌人
            if(hero.shots.get(i) != null && hero.shots.get(i).isLive){
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(hero.shots.get(i), enemyTank);
                }
            }
        }
    }

    //子弹是否击中敌人
    public  void hitTank(Shot s, TanKe Tank){
        //判断s是否击中坦克
        switch (Tank.getDirect()){
            case 0://向上
            case 2://向下
                if(s.x > Tank.getX() && s.x < Tank.getX() + 40 &&
                s.y > Tank.getY() && s.y < Tank.getY() + 60){
                    s.isLive = false;
                    Tank.isLive = false;
                    enemyTanks.remove(Tank);
                    //创建bomb对象，加入到bombs中
                    Bomb bomb = new Bomb(Tank.getX(),Tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://向左
            case 3://向右
                if(s.x > Tank.getX() && s.x < Tank.getX() + 60 &&
                s.y > Tank.getY() && s.y < Tank.getY() + 40){
                    s.isLive = false;
                    Tank.isLive = false;
                    enemyTanks.remove(Tank);
                    //创建bomb对象，加入到bombs中
                    Bomb bomb = new Bomb(Tank.getX(),Tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    //编写方法，敌人坦克是否可以击中我方的坦克
    public void hitHero(){
        //遍历所有敌人的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人的坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if(hero.isLive && shot.isLive){
                    hitTank(shot, hero);
                }
            }
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
            if(hero.getY() > 0){
                hero.moveUp();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);      //设置坦克的方向为右
            if(hero.getX() + 60 < 1000){
                hero.moveRight();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);      //设置坦克的方向为下
            if(hero.getY() + 60 < 750){
                hero.moveDown();
            }
        } else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);      //设置坦克的方向为左
            if(hero.getX() > 0){
                hero.moveLeft();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_J){
            //判断当前hero的子弹是否已经销毁,发射一颗子弹
//            if(hero.shot == null || !hero.shot.isLive){
//                hero.shotEnemyTank();
//            }
            //发射多颗子弹
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
//            //判断是否击中敌人坦克
//            if(hero.shot != null && hero.shot.isLive){//当前子弹存活
//                //遍历敌人所有的坦克
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTank(hero.shot, enemyTank);
//                }
//            }
            hitEnemyTank();
            hitHero();
            this.repaint();
        }
    }
}
