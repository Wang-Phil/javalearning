package JavaEE.chapter07.houserent.view;

import JavaEE.chapter07.houserent.domain.House;
import JavaEE.chapter07.houserent.service.HouseService;
import JavaEE.chapter07.houserent.utils.Utility;

import javax.swing.*;

/**
 * 1、显示界面
 * 2、接受用户的输入
 * 3、调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;        //控制显示菜单
    private char key = ' ';             //接受用户输入
    private HouseService houseService = new HouseService(10);

    //编写listHouses()显示房屋列表
    public void listHouses(){
        System.out.println("===============房屋列表================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null) break;    //如果是空，不用再显示
            System.out.println(houses[i]);
        }
        System.out.println("=================房屋列表显示完毕===============");
    }

    //编写addHouse（）显示新增房屋
    public void addHouse(){
        System.out.println("----------------添加房屋--------------");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态: ");
        String state = Utility.readString(3);
        //创建一个新的House对象，注意id，是系统进行分配
        House newHouse = new House(0,name, phone, address, rent, state);
        if(houseService.add(newHouse)){
            System.out.println("=========添加房屋成功===========");
        }
        else{
            System.out.println("=========添加房屋失败===========");
        }
    }

    //编写deleteHouse，删除房屋的功能
    public void deleteHouse(){
        System.out.println("----------------添加房屋--------------");
        System.out.println("请选择删除房屋的编号（-1退出）:：");
        int id = Utility.readInt();
        if(id == -1){
            System.out.println("===========放弃删除房屋信息==========");
            return;
        }
        char choice = Utility.readConfirmSelection();   //该方法本身就有循环判断的逻辑
        if(choice == 'Y'){
            if(houseService.delete(id)){
                System.out.println("=========删除房屋成功===========");
            }
            else{
                System.out.println("=========编号不存在，删除房屋失败===========");
            }
        }
    }

    //编写查找房屋findHouse的功能
    public void findHouse(){
        System.out.println("----------------查找房屋--------------");
        System.out.println("请输入你要查找的的id：");
        int id = Utility.readInt();
        House house = houseService.find(id);
        if(house != null){
            System.out.println("查找成功！");
        }
        else {
            System.out.println("=====找到了房屋，房屋信息是：=======");
            System.out.println(house);
        }
    }

    //修改房屋的信息功能modifyHouse
    public void modifyHouse(){
        System.out.println("----------------修改房屋--------------");
        System.out.println("请输入你要修改的的id：(1-"+ houseService.getIdCounter() + ")");
        int id = Utility.readInt();
        while(id < 1 || id > houseService.getIdCounter()){
            System.out.println("输入编号有误，请重新输入:(1-"+ houseService.getIdCounter() + ")");
            id = Utility.readInt();
        }
        House house = houseService.find(id);
        System.out.print("姓名("+ house.getName() +"):");
        String name = Utility.readString(8, " ");
        if(!name.equals(" ")){
            house.setName(name);
        }
        System.out.print("电话:("+ house.getPhone() +"):");
        String phone = Utility.readString(12," ");
        if(!phone.equals(" ")){
            house.setPhone(phone);
        }
        System.out.print("地址:("+ house.getAddress() +"):");
        String address = Utility.readString(16," ");
        if(!address.equals(" ")){
            house.setAddress(address);
        }
        System.out.print("月租:("+ house.getRent() +"):");
        int rent = Utility.readInt(-1);
        if(rent != -1){
            house.setRent(rent);
        }
        System.out.print("状态:("+ house.getState() +"):");
        String state = Utility.readString(3," ");
        if(!state.equals(" ")){
            house.setState(state);
        }
        System.out.println("=========修改房屋成功===========");
    }

    //完成退出确认
    public void exit(){
        char ch = Utility.readConfirmSelection();
        if(ch == 'Y') loop = false;
    }

    //显示主菜单
    public void mainMenu(){
        do{
            System.out.println("============房租出租系统菜单===============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 显 示 房 屋 信 息");
            System.out.println("\t\t\t6 退        出");
            System.out.println("请输入你的选择(1-6):");
            key = Utility.readChar();
            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    modifyHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;

            }
        }while(loop);
    }
}
