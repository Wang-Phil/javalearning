package JavaEE.chapter08.homework;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork02 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        cat.shout();
        dog.shout();
    }
}

abstract class Animal{
    abstract void shout();
}

class Cat extends Animal{
    @Override
    void shout() {
        System.out.println("猫会喵喵叫");
    }
}

class Dog extends Animal{
    @Override
    void shout() {
        System.out.println("狗会汪汪叫");
    }
}



