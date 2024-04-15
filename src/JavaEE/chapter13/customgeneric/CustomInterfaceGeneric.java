package JavaEE.chapter13.customgeneric;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}

//接口中，成员属性时默认静态的 final static
interface IUsb<U,R>{
    //普通方法，可以使用泛型接口
//    U name; //报错，成员属性时默认静态的 final static
    void run(R r1,U u1);
    //在jdk8中，可以在接口中，使用默认方法，也是可以使用泛型
    default R method(U u){
        return null;
    }
}

//继承接口时，指定类型 U->String, R->Double
interface AUsb extends IUsb<String, Double>{}

//实现接口时，指定类型 U->String, R->Double
class BUsb implements IUsb<String, Double>{
    @Override
    public void run(Double r1, String u1) { //自动填充类型
    }
}
//未指定，默认为Object
class CUsb implements IUsb{
    @Override
    public void run(Object r1, Object u1) {//默认为Object
    }
}
