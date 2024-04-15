package JavaEE.chapter08.CodeBlock;

public class CodeBlockDetail02 {
    public static void main(String args[]){
        A a = new A();
    }
}

class A{
    private int n2 = getN2();
    private static int n1 = getN1();

    {
        System.out.println("A的普通代码块");
    }

    static {
        System.out.println("A的静态代码块");
    }

    public static int getN1(){
        System.out.println("getn1被调用");
        return 100;
    }

    public int getN2(){
        System.out.println("A普通方法被调用");
        return 200;
    }

    public A(){
        System.out.println("无参构造器");
    }

}
