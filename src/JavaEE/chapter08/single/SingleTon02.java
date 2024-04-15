package JavaEE.chapter08.single;

/**
 * 懒汉式单例模式
 */
public class SingleTon02 {
    public static void main(String[] args) {
        //Cat类加载，并不会加载构造器
        System.out.println(Cat.n1);
        Cat instance = Cat.getInstance();
        System.out.println(instance);

        //再次调用的时候，直接使用上次的对象
        Cat instance2 = Cat.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);
    }

}
//单例设计模式的懒汉式
class Cat{
    private String name;
    public static int n1 = 999;

    //第一步：构造器私有化
    private Cat(String name) {
        System.out.println("类加载。。。。");
        this.name = name;
    }

    //第二步：定义一个新的static静态对象
    private static Cat cat;

    //第三步：提供一个public的static方法，可以返回一个Ca对象
    public static Cat getInstance(){
        //还没有对象，就创建对象
        if(cat == null){
            cat = new Cat("小花喵");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}