package JavaEE.chapter08.CodeBlock;

public class CodeBlockDetail03 {
    public static void main(String[] args) {
        new BBB();
    }
}

class AAA{
    public AAA(){
        //（1）super
        //（2）普通代码块
        System.out.println("AAA() 无参构造器被调用");
    }
}

class BBB extends AAA{
    {
        System.out.println("普通代码块被调用");
    }
    public BBB(){
        //（1）super
        //（2）普通代码块
        System.out.println("BBB() 无参构造器被调用");
    }
}

