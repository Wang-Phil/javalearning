package JavaEE.chapter10;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ClassCastException {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = (C)b;
    }
}

class A{

}

class B extends A{

}
class C extends B{

}
