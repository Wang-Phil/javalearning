package JavaEE.chapter13.customgeneric;

import java.util.ArrayList;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class CustomMethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        //调用方法，传入参数，编译器，就会确定类型
        car.run("run"); //调用的时候指定泛型的类型
        new Fish<Integer>().swim1(2);
        Fish fish = new Fish<Integer>();
        fish.swim(2,new ArrayList());
    }
}

class Car{//普通类的泛型方法
    public<E> void run(E e){
        System.out.println("泛型方法类型为"+e.getClass());
    }
}

class Fish<T>{//泛型类里面的泛型方法
    public<U> void swim(U u, T t){  //泛型使用了泛型类的泛型，也可以使用自己方法里面的泛型
        System.out.println(u.getClass());
        System.out.println(t.getClass());
    }
    public  void swim1(T t){    //使用了泛型，但是不是泛型方法
        System.out.println(t.getClass());
    }
}
