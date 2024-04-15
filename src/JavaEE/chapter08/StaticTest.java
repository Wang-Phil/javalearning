package JavaEE.chapter08;

public class StaticTest {
    public static void main(String[] args) {
        //类名.类变量名
        //类变量是随着类的加载而创建，不用创建对象也可以访问
        System.out.println(A.name);
        A a = new A();
        //通过对象名.类变量名也可以访问
        System.out.println(a.name);
    }
}

class A{
    //类变量也需要遵循相关的访问权限
    public static String name = "你好";
}
