package JavaEE.tankegame2;

/**
 * @version 1.0
 * @auther wangweicheng
 * 敌人的坦克
 */
public class EnemyTank extends TanKe{
    public EnemyTank(int x, int y){
        super(x,y);
    }

    public EnemyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
}
