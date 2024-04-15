package JavaEE.chapter08.abstrate_;

public class Abstract03 {
    public static void main(String[] args) {
        new Cat().calculate();
        new Tiger().calculate();
    }
}

abstract class Template{
    public abstract void job();

    //一部分抽象，一部分不抽象，可以转变为一个模板，提供给子类实现
    public void calculate(){
        long time = System.currentTimeMillis();
        job();
        long nowtime = System.currentTimeMillis();
        System.out.println("该任务执行时间为："+(nowtime-time));
    }
}

class Cat extends Template{
    //子类只需要负责实现抽象部分即可
    public void job(){
        long sum = 0;
        for (int i = 0; i < 8000000; i++) {
            sum += i*2;
        }
    }
}

class Tiger extends Template{
    //子类只需要负责实现抽象部分即可
    public void job(){
        long sum = 0;
        for (int i = 0; i < 8000000; i++) {
            sum += i;
        }
    }
}