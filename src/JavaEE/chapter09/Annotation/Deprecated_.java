package JavaEE.chapter09.Annotation;

/**
 * @version 1.0
 * @auther wangweicheng
 * 过时注解说明
 */
public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
    }
}

//表示某个元素已经过时了，不推荐使用，但是仍然可以使用
//可以修饰方法，类，字段，包，参数，等等
//可以用来版本升级兼容过渡使用
/*
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.METHOD,ElementType.PACKAGE,ElementType.PARAMETER,ElementType.TYPE})

 */
@Deprecated
class A{
    public int n1 = 10;
    public void hi(){
    }
}
