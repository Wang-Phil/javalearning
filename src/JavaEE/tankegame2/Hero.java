package JavaEE.tankegame2;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Hero extends TanKe {
    public Hero(int x, int y){
        super(x,y);
    }

    public Hero(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
}
