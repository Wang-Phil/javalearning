package JavaEE.chapter08.final_;

public class Final01 {
    public static void main(String[] args) {
        E e = new E();
        System.out.println(e.TAXI_RATE);
        //final不能被再次赋值
        //e.TAXI_RATE = 0.9;

    }
}

//1、类的final,不能被继承
final class A{

}

//class B extends A{
//
//}

//2、方法的final,不能被重写
class C{
    //如果要求不能被重写，可以是加入一个final
     public final void hi(){

    }
}

//class D extends C{
//    public void hi(){
//        System.out.println("重写这个方法");
//    }
//}

//变量的final
class E{
    public final Double TAXI_RATE = 0.8;
}


