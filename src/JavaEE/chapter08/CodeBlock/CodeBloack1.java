package JavaEE.chapter08.CodeBlock;

public class CodeBloack1 {
    public static void main(String[] args) {
        //1、创建实例对象被加载
        AA aa = new AA();
        //2、创建子类对象，父类被加载
        BB bb = new BB();
        //3、静态属性被加载时，类会被加载
        System.out.println(Cat.n1);
        DD dd = new DD();
        System.out.println(DD.n1);
        System.out.println(dd.n1);




    }
}

class AA{
    //静态代码块
    static{
        System.out.println("AA的静态代码块被执行；");
    }
}

class BB extends AA{

}

class Cat{
    public static int n1 = 999;
    static {
        System.out.println("Cat 静态代码块被加载");
    }
}

class DD{
    public static int n1 = 99;
    //普通代码块，在创建对象时，被调用，每创建一次，就会调用一次，和类加载无关
    {
        System.out.println("DD普通代码块");
    }
}

