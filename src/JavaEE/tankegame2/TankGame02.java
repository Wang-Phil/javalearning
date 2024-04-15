package JavaEE.tankegame2;

import javax.swing.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TankGame02 extends JFrame {
    //初始化MyPanel
    MyPanel mp = null;

    public TankGame02() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);   //监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame02 hspTankGame02 = new TankGame02();
    }
}
