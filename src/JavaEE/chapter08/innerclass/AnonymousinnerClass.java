package JavaEE.chapter08.innerclass;

public class AnonymousinnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04{//外部类
    private int n1 = 10;//属性
    public void method(){//方法
        //基于接口的匿名内部类
        //1、需要A接口，并创建对象
        //2、传统方法，是写一个类，实现接口，并创建对象
        //3、只需要使用一次，后面不需要再使用
        //4、使用匿名内部类简化开发
        //5、匿名内部类tiger的运行类型为 Outer04$1，编译类型是A
        //6、匿名内部类的底层实现：
        /*
            class Outer04$ implement A{
                public void cry() {
                System.out.println("老虎在叫");
                }
            }
         */
        //7、jdk在底层创建匿名内部类Outer04$1,立马就创建了Outer04$01实例，并且把地址返回
        //8、匿名内部类使用一次就不再使用
        A tiger = new Tiger(){
            public void cry() {
                System.out.println("老虎在叫");
            }
        };
        tiger.cry();
//        A tiger = new Tiger();
//        tiger.cry();

        //基于类的匿名内部类
        //编译类型 Father，运行类型Outer04$2
        //底层实现：
        /*
            class Outer04$02 extends Father{}

         */
        //参数会传给father的构造器
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("father的运行类型" + father.getClass());
        father.test();

        //使用
        new Person(){
            @Override
            public void hi() {
                System.out.println("匿名内部类使用hi");
            }
        }.hi();
    }
}

interface A{//接口
    public void cry();
}

class Tiger implements A{
    @Override
    public void cry() {
        System.out.println("老虎在叫");
    }
}

class Father{
    public Father(String name){

    }
    public void test(){

    }
}

class Person{
    public void hi(){
        System.out.println("person hi");
    }
}