package JavaEE.chapter08;

public class Main01 {
    //静态变量和属性
    public static String name = "nihao1";
    public static void main(String[] args) {
        //静态方法可以访问静态属性和方法
        System.out.println(name);
        Main01.hei();
    }
    public static void hei(){
        System.out.println("hei");
    }
}
