package JavaEE.chapter08.abstrate_;

public class Abstract01 {
    public static void main(String[] args) {

    }
}

//抽象类不能被实例化，有抽象方法，这个类必须声明为abstract
abstract class AA{
    //抽象方法没有方法体
    public abstract void eat();
}

abstract class BB{
    //属性
    private String name;
    //构造器
    public BB() {
    }
    //普通方法
    public void cal(){
        System.out.println("抽象类可以没有抽象方法");
    }
    //抽象方法
    abstract void hi();
}

abstract  class E{
    public abstract void hi();
    public abstract void sorry();
}

class F extends E{
    public void hi(){
        System.out.println("hi");
    }
    public void sorry() {
        System.out.println("sorry");
    }
}
