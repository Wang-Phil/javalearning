package JavaEE.chapter08;

public class Student {
    public static void main(String[] args) {
        //类.类方法进行调用
        Stu.Pay(100);
        Stu.Pay(200);
        Stu.Show();
        System.out.println(MyTools.calSum(10,30));
    }
}

//开发自己的工具类，可以将方法做成静态的，方便调用
class MyTools{
    public static double calSum(double n1, double n2){
        return n1 + n2;
    }
}

class Stu{
    public static double totalFee = 0;
    private String name;

    public Stu(String name) {
        this.name = name;
    }
    //1、方法使用static修饰时，该方法就为静态方法
    //2、静态方法只能访问静态变量
    public static void Pay(double fee){
        Stu.totalFee += fee;
    }
    public static void Show(){
        System.out.println("总学费为"+totalFee);
    }
}
