package JavaEE.chapter13.generic;

import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class GeneralGeneric {
    public static void main(String[] args) {
        //<?> 可以接受任意类型的泛型
        method1(new ArrayList<Object>());
        method1(new ArrayList<String>());
        method1(new ArrayList<A>());

        //<? extends A>可以接受其本身或者子类的泛型
        method2(new ArrayList<A>());
        method2(new ArrayList<B>());
//        method2(new ArrayList<String>());   //报错

        //<? super A>可以接受其本身或者父类的泛型
        method3(new ArrayList<A>());
        method3(new ArrayList<Object>());
//        method2(new ArrayList<B>());   //报错
    }
    public static void method1(List<?> list){}
    public static void method2(List<? extends A> list){}
    public static void method3(List<? super A> list){}
}

class A{}
class B extends A{}

