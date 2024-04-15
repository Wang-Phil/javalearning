package JavaEE.chapter08.homework;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork04 {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
    }
}

class A{
    private String name = "早上复习";
    public void m1(){
        class B{
            private final String  name = "晚上复习";
            public void show(){
                System.out.println("测试内部类"+name+"测试外部类"+A.this.name);
            }
        }
        B b = new B();
        b.show();
    }
}
