package JavaEE.chapter08.homework;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork03 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Caucalcate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },1,2);
    }
}

interface Caucalcate{
    public double work(double n1, double n2);
}

class Cellphone {
    public void testWork(Caucalcate caucalcate, double n1, double n2){
        System.out.println("测试手机");
        double ans = caucalcate.work(n1, n2);
        System.out.println("计算结果为"+ans);
    }
}


