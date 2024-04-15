package JavaEE.chatper12.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork02 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        List list1 = new ArrayList<>();
        Car car = new Car("宝马", 128013.12);
        Car car2 = new Car("宾利", 300021.12);
        list.add(car);
        list.add(car2);
        list1.add(car);
        list1.add(car2);
        list.remove(car);
        System.out.println(list.contains(car));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.clear();
        list.addAll(list1);
        System.out.println(list.containsAll(list1));
        System.out.println(list.removeAll(list1));
        System.out.println(list.addAll(list1));

        //增强for循环遍历
        for(Object o : list){
            System.out.println(o);
        }

        //迭代器遍历
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

class Car{
    private String name;
    private double price;

    public Car(String name,double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

