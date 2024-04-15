package JavaEE.chapter13.customgeneric;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class CustomGeneric_ {
    public static void main(String[] args) {

    }
}
//Tiger 后面的为泛型，Tiger就称为自定义泛型类
//T,R,M 为泛型的标识符，一般是单个的大写字母
//普通成员可以使用泛型（属性，方法）
class Tiger<T,R,M>{
    String name;
    T t;        //属性使用泛型
    R r;
    M m;
//    T[] t1 = new T[8];  //报错，无法确定数组类型，数组不知道开辟多大空间
    public Tiger(String name, T t, R r, M m) {  //方法使用泛型
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }
    //静态方法，静态属性，是在类加载的时候进行的，但是对象还没有创建，JVM就无法初始化
//    static R r2;
//    public static void m1(T t){}
}