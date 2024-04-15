package JavaEE.chapter08.interface_;

public class ExtendsVSImterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("孙悟空");
        littleMonkey.climbing();
        littleMonkey.swimming();
        littleMonkey.flying();
    }
}

//父类
class Monkey{
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void climbing(){
        System.out.println(getName()+"猴子会爬树！");
    }
}

//接口类
interface Fishable{
    void swimming();
}

interface  Birdable{
    void flying();
}

//子类继承父类，实现接口
class LittleMonkey extends Monkey implements Fishable, Birdable{
    public LittleMonkey(String name) {
        super(name);
    }
    //实现抽象类方法
    @Override
    public void swimming() {
        System.out.println(getName() +"学会了游泳");
    }

    @Override
    public void flying() {
        System.out.println(getName()+"学会了飞");
    }
}
