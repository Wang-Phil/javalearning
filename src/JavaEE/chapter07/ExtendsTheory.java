package JavaEE.chapter07;

/**
 * 讲解继承的本质
 */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();
        //按照查找关系来返回信息
        //(1)首先看子类是否有该属性，如果子类有这个属性，并且可以访问，则返回信息
        //(2)如果子类没有这个属性，就看父类有咩有属性（如果有并且可以访问，则返回信息）
        //(3)如果父类没有，就按照（2）的规则，继续往上找上级的父类，直到object类
        System.out.println(son.name);   //返回是大头儿子
        System.out.println(son.age);    //返回是39
        System.out.println(son.hobby);  //返回的是旅游
    }
}

class GrandPa{
    String name = "大头爷爷";
    String hobby = "旅游";
}
class Father extends GrandPa{
    String name = "大头爸爸";
    int age = 39;
}
class Son extends Father{
    String name = "大头儿子";

}
