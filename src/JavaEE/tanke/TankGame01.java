package JavaEE.tanke;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TankGame01 extends JFrame {
    //初始化MyPanel
    MyPanel mp = null;

    public TankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame01 hspTankGame01 = new TankGame01();
    }
}
