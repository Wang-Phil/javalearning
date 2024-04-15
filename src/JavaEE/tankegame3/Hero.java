package JavaEE.tankegame3;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Hero extends TanKe {
    Shot shot = null;
    public Hero(int x, int y){
        super(x,y);
    }

    public Hero(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }

    //射击
    public void shotEnemyTank(){
        //创建shot对象，根据hero当前位置和方向来创建子弹
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
        Thread thread = new Thread(shot);
        thread.start();
    }


}
