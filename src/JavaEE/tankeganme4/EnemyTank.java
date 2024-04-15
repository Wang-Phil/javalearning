package JavaEE.tankeganme4;

import java.util.Vector;

/**
 * @version 1.0
 * @auther wangweicheng
 * 敌人的坦克
 */
public class EnemyTank extends TanKe implements Runnable {
    public EnemyTank(int x, int y){
        super(x,y);
    }
    public EnemyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
    Vector<Shot> shots = new Vector<>();

    @Override
    public void run() {
        while(true){
            //这里控制好子弹的数量
            if(isLive && shots.size() < 1){
                Shot shot = null;
                switch (getDirect()){
                    case 0://向上
                        shot = new Shot(getX() + 20,getY(),0);
                        break;
                    case 1://向上
                        shot = new Shot(getX() + 60,getY() + 20,1);
                        break;
                    case 2://向上
                        shot = new Shot(getX() + 20,getY() + 60,2);
                        break;
                    case 3://向上
                        shot = new Shot(getX(),getY() + 20,3);
                        break;
                }
                //启动shot线程
                shots.add(shot);
                new Thread(shot).start();
            }
            //根据坦克的方向继续移动
            switch (getDirect()){
                case 0://向上
                    //让坦克保持一个方向多走几步
                    for (int i = 0; i < 30; i++) {
                        if(getY() > 0){
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://向右
                    //让坦克保持一个方向多走几步
                    for (int i = 0; i < 30; i++) {
                        if(getX() + 60 < 1000){
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://向下
                    //让坦克保持一个方向多走几步
                    for (int i = 0; i < 30; i++) {
                        if(getY() + 60 < 750){
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://向左
                    //让坦克保持一个方向多走几步
                    for (int i = 0; i < 30; i++) {
                        if(getX() > 0){
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //随机改变坦克方向
            setDirect((int)(Math.random()*4));
            //一旦写并发程序，要考虑清楚该线程什么时候结束
            if(!isLive){
                break;  //退出线程
            }
        }
    }
}
