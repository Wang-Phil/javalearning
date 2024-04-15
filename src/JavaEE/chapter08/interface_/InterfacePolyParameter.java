package JavaEE.chapter08.interface_;

public class InterfacePolyParameter {
    public static void main(String[] args) {
        //接口的多态，
        //接口类型的变量 if01可以指向实现了IF接口的类的对象实例
        IF if01 = new Monster();
        if01 = new Car();

        //多态数组
        IF[] if02 = new IF[2];
        if02[0] = new Monster();
        if02[1] = new Car();
    }
}

interface IF{}
class Monster implements IF {}
class Car implements  IF{}
