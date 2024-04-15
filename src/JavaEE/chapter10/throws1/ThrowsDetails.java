package JavaEE.chapter10.throws1;

import java.io.FileNotFoundException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ThrowsDetails {
    public static void main(String[] args) {

    }

    public static void f1(){
        //运行时异常，会默认throws
        f2();
    }
    public static void f2() throws NullPointerException{

    }

    public static void f3() throws Exception{
        //而编译类型的异常必须进行处理，否则会报错,调用者抛出的异常可以是之前的异常，或者之前的异常的父类
        f4();
    }

    public static void f4() throws FileNotFoundException {

    }
}

class A{
    public void f1() throws Exception{

    }
}

class B extends A{
    @Override
    //子类抛出的异常必须是父类的子类或者父类的异常
    public void f1() throws NullPointerException {
    }
}

