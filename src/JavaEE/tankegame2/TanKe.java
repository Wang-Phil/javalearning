package JavaEE.tankegame2;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TanKe {
    //坦克的横中坐标
    private int x;
    private int y;
    private int direct; //坦克的方向，0,1,2,3分别表示上、右，下，左
    private int speed;  //坦克的速度

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public TanKe(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp(){
        y -= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public TanKe(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void moveLeft(){
        x -= speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
