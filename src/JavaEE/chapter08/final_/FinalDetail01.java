package JavaEE.chapter08.final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        BB bb = new BB();
        bb.cal();
        System.out.println(Demo.n1);
    }
}

class AA{
    final public void cal(){
        System.out.println("CAL方法");
    }
}

class BB extends AA{

}

class Demo{
    public final static int n1 = 16;
    static {
        System.out.println("这里是类加载，不会被执行");
    }
}


