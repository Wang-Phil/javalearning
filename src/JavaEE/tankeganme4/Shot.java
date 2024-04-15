package JavaEE.tankeganme4;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Shot implements Runnable{
    int x;                      //子弹的x坐标
    int y;                      //子弹的y坐标
    int speed = 10;              //子弹的速度
    int direct;                 //子弹的方向
    boolean isLive = true;     //子弹是否存活

    public Shot(int x, int y,int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while(true){
            switch (direct){
                case 0: //向上
                    y -= speed;
                    break;
                case 1://向右
                    x += speed;
                    break;
                case 2://向下
                    y += speed;
                    break;
                case 3://向左
                    x -= speed;
                    break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //测试，判断是否在移动
            System.out.println("子弹 x="+ x +"  y="+y);
            //子弹越界即销毁,碰到敌人坦克时，也销毁
            if(!(x >= 0 && x <= 1000 && y > 0 && y < 750 && isLive)){
                System.out.println("子弹线程被退出");
                isLive = false;
                break;
            }
        }
    }
}
