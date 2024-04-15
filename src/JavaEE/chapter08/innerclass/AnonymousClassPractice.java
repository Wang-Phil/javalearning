package JavaEE.chapter08.innerclass;

/**
 * 匿名内部类的实践
 */

public class AnonymousClassPractice {
    public static void main(String[] args) {
        //1、将匿名内部类直接当做实参传入函数当中
        f1(new Fot() {//软编码模式
            @Override
            public void show() {
                System.out.println("匿名内部类重写show方法");
            }
        });
        //正常实现,比较麻烦
        Example example = new Example();
        f1(example);
    }

    public static void f1(Fot fot){
        fot.show();
    }
}

interface Fot{
    void show();
}

//硬编码模式
class Example implements Fot{
    @Override
    public void show() {
        System.out.println("普通类重写show方法");
    }
}

