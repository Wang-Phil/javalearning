package JavaEE.chapter09;
/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//演示自定义枚举
class Season{
    private String name;
    private String desc;//描述

    //定义四个对象
    public final static Season SPRING = new Season("春天", "温暖");
    public final static Season SUMMER = new Season("夏天", "炎热");
    public final static Season AUTUMN = new Season("秋天","凉爽");
    public final static Season WINTER = new Season("冬天","寒冷");

    //1、将构造器私有化，防止直接new
    //2、去掉SetXXX方法，防止属性被修改
    //3、在Seaon内部，直接创建固定的对象。
    //4、可以加入final修饰符，进行优化
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
    //    public String getDesc() {
//        return desc;
//    }
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
}
