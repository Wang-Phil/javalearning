package JavaEE.chapter08.single;

public class SingleTon01 {
    public static void main(String[] args) {
        //非单例模式：
//        GirlFriend xb = new GirlFriend("小白");
//        GirlFriend xh = new GirlFriend("小红");

        //通过方法获取对象
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);
    }
}

class GirlFriend {
    private String name;

    //第一步：将构造器私有化
    private GirlFriend(String name){
        this.name = name;
    }

    //第二步，在类的内部直接创建静态对象
    private static GirlFriend gf = new GirlFriend("小红");

    //第三步：提供一个公共的static方法，返回gf对象
    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
