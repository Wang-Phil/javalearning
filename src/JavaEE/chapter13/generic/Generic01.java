package JavaEE.chapter13.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Generic01 {
    public static void main(String[] args) {
        //1、常见集合使用了泛型： public class ArrayList<E>，这里指定E为Integer类型
        List list = new ArrayList<Integer>();
        //E在定义的时候，也就是编译的时候确定E为String类型
        Person<String> person = new Person<String>("Jack");
        person.show();
    }
}

//创建类或者接口的时候可以使用泛型
class Person<E> {   //泛型在编译时，确定类型
    E s;
    public Person(E s) {    //可以是参数类型
        this.s = s;
    }
    //方法也可以使用泛型
    public E function01(){
        return s;           //可以是返回类型
    }

    public void show(){
        System.out.println(s.getClass());
    }
}
