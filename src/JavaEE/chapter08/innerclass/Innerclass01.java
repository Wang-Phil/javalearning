package JavaEE.chapter08.innerclass;

public class Innerclass01 {
    public static void main(String[] args) {

    }
}

class Outer{//外部类
    //属性
    private int n1 = 100;

    //构造器
    public Outer(int n1) {
        this.n1 = n1;
    }
    //方法
    public void m1(){
        System.out.println("方法");
    }
    //代码块
    {
        System.out.println("代码块...");
    }
    //内部类
    class Inner{//内部类，在Outer类的内部

    }
}
