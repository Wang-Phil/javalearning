package JavaEE.chapter08.innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {

    }
}

class Outer09{
    private static int n1 = 10;
    public static String name = "张三";
    //1、内部类是定义在外部类的成员位置
    //2、可以用public、private、protected修饰
    //3、作用域在整个类体
    static class Inner09{//成员内部类
        public String name = "李四";
        public void say(){
            //4、可以访问外部类的所有成员，包含私有的
            System.out.println("n1 = "+ n1 + " name = "+name+"外部类的name访问："+Outer09.name);
        }
    }

    public void t1(){
        //5、外部类使用内部类，创建对象，使用他的成员即可
        Outer09.Inner09 inner09 = new Outer09.Inner09();
        inner09.say();
    }

    public Outer09.Inner09 getInner08Instance(){
        return new Outer09.Inner09();
    }
}
