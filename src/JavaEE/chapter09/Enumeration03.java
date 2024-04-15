package JavaEE.chapter09;

/**
 * @version 1.0
 * @auther wangweicheng
 * 这里主要介绍了枚举类实现
 */
public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
    }
}

//演示枚举类实现
enum Season2{
    SPRING("春天", "温暖"),SUMMER("夏天", "炎热"), AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");
    private String name;
    private String desc;//描述
    //1、将class 用enum替换
    //2、定义常量名，定义方式为常量名（参数列表），必须写在前面
    //3、有多个对象，需要使用逗号，进行间隔
    //4、如果是无参构造器，直接可以省略括号。

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}