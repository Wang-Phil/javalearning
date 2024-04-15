package JavaEE.chapter07.houserent.service;

import JavaEE.chapter07.houserent.domain.House;

/**
 * 1、定义House数组，保存House对象
 * 2、响应HouseView的调用
 * 3、完成对房屋信息的各种操作（增删改查crud）
 */
public class HouseService {
    private House[] houses; //保存House对象
    private int houseNums = 1; //记录当前房屋信息
    private int idCounter = 1; //id自增长的序号
    //构造器
    public HouseService(int size){
        houses = new House[size];   //指定数组大小
        //测试，输出一个对象
        houses[0] = new House(1,"jack","112","海淀区",2000,"未出租");
    }

    //删除方法，输入编号对数组进行删除
    public boolean delete(int id){
        int index = -1;
        //找到下标
        for (int i = 0; i < houseNums; i++) {
            if(id == houses[i].getId()) index = i;
        }
        if(index == -1) return false;
        //进行前移删除覆盖
        for(int i = index; i < houseNums - 1; i++)
            houses[i] = houses[i+1];
        houses[houseNums-1] = null;
        houseNums--;
        return true;
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse){
        //判断是否还可以继续添加
        if(houseNums >= houses.length){
            System.out.println("数组已满，不能再添加");
            return false;
        }
        houses[houseNums] = newHouse;
        houseNums++;    //新增房屋个数
        idCounter++;
        newHouse.setId(idCounter);  //重新设置idCounter
        return true;
    }

    //find查找功能，根据id查找房屋信息
    public House find(int id){
        int index = -1;
        for(int i = 0; i < houseNums; i++){
            if(houses[i].getId() == id) index = i;
        }
        if(index == -1) return null;
        else{
            return houses[index];
        }
    }

    //修改房屋信息
    public boolean modify(int id, House house){
        //判断是否还可以继续添加
        int index = -1;
        for(int i = 0; i < houseNums; i++){
            if(houses[i].getId() == id) index = i;
        }
        if(index == -1) return false;
        houses[index] = house;
        return true;
    }

    //list方法，返回houses
    public House[] list(){
        return houses;
    }

    public int getHouseNums() {
        return houseNums;
    }

    public void setHouseNums(int houseNums) {
        this.houseNums = houseNums;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }
}
