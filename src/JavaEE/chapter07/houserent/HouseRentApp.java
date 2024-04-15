package JavaEE.chapter07.houserent;

import JavaEE.chapter07.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView对象，并且显示主菜单，是程序入口
        new HouseView().mainMenu();
        System.out.println("退出房屋出租系统");
    }
}
