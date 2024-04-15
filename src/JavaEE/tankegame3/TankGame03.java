package JavaEE.tankegame3;

import javax.swing.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TankGame03 extends JFrame {
    //初始化MyPanel
    MyPanel mp = null;

    public TankGame03() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);   //监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame03 hspTankGame02 = new TankGame03();
    }
}
