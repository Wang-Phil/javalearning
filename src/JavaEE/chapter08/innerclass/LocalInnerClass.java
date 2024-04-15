package JavaEE.chapter08.innerclass;

/**
 * 局部内部类的演示
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}

class Outer02{//外部类
    private int n1 = 10;
    private void m2(){}//私有方法
    public void m1(){//方法
        //1、局部内部类是定义在外部类的局部位置，通常实在方法里面
        //3、不能添加访问修饰符，但是可以使用final修饰（不能被继承）
        //4、作用域：仅仅在方法或代码块中
        class Inner02{  //局部内部类（本质仍为一个类）
            private int n1 = 800;
            public void f1(){
                //2、可以直接访问外部类的所有成员，包含私有的
                //5、局部内部类可以直接访问外部类的成员，比如n1，m2()
                //7、如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，可以使用 外部类名.this.成员去访问
                //Outer02.this 的本质就是外部类的对象，哪个对象调用了m1，Outer02.this就是哪个对象
                System.out.println("内部类n1= "+n1);
                System.out.println("外部类的n1 ="+Outer02.this.n1);
                m2();
            }
        }
        //6、外部类在方法中，可以创建Inner02对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}
