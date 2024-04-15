package JavaEE.chatper12.set_;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        Set linkedHashSet = new LinkedHashSet();

        linkedHashSet.add(new Car("奥拓", 1000));//OK
        linkedHashSet.add(new Car("奥迪", 300000));//OK
        linkedHashSet.add(new Car("法拉利", 10000000));//OK
        linkedHashSet.add(new Car("奥迪", 300000));//加入不了
        linkedHashSet.add(new Car("保时捷", 70000000));//OK
        linkedHashSet.add(new Car("奥迪", 300000));//加入不了
        System.out.println("linkedHashSet=" + linkedHashSet);
    }
}

class Car{
    String name;
    int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

