package JavaEE.chapter08.interface_;

public class InterfacePoly {
    public static void main(String[] args) {
        //接口类型变量可以指向，实现该接口的类的对象实例
        IG ig = new Teacher();
        //IG继承了IH接口，Teacher实现了IG接口，相当于Teacher实现了IH接口，这就是接口的多态传递现象
        IH ih = new Teacher();
    }
}
interface IH{}
interface IG extends IH{}
class Teacher implements IG{}