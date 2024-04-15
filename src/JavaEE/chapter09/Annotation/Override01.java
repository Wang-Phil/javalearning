package JavaEE.chapter09.Annotation;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Override01 {
    public static void main(String[] args) {

    }
}

class Father{
    public void fly(){
        System.out.println("父类的飞");
    }
}
class Son extends Father{
    //重写父类的方法，不写也会重写
    // 但是写了Override注解，编译器就会去检查是否真的重写
    //如果的确重写了，编译器通过，如果没有重写，就会编译错误
    /* 如果发现了一个@interface，说明是一个注解类
    源码：
        @Target({ElementType.METHOD})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Override
     */
    @Override
    public void fly() {
        System.out.println("子类重写了父类的方法");
    }
}
