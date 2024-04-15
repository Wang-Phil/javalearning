package JavaEE.chapter08.interface_;

public class Interface01 {
    public static void main(String[] args) {

    }
}

interface AInterface{
    public int n1 = 10;
    //抽象方法
    public abstract void hi();
    //使用关键字default修饰之后，可以实现具体的方法
    default void ok(){
        System.out.println("这里可以声明方法");
    }
    //使用static修饰之后，也可以实现具体的方法
    static void you(){
        System.out.println("这里可以声明方法");
    }
}

//需要实现接口类的所有抽象方法
class A implements AInterface{
    @Override
    public void hi() {
        System.out.println("实现接口类");
    }
}

//抽象类可以不用实现抽象方法
abstract class B implements AInterface{
}