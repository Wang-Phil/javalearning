package JavaEE.tanke;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TanKe {
    //坦克的横中坐标
    private int x;
    private int y;

    public TanKe(int x, int y) {
        this.x = x;
        this.y = y;
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
