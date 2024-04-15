package JavaEE.chapter11.packageclass;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class WrapperVSString {
    public static void main(String[] args) {
        //包装类型和String类型的相互转换
        //包装类（Integer）-> String
        Integer integer = 100;
        //方式1：
        String str1 = integer + "";
        //方式2：
        String str2 = integer.toString();
        //方式3：
        String str3 = String.valueOf(integer);

        //String->Integer
        String string = "12345";
        Integer integer1 = Integer.parseInt(string);    //使用到了自动装箱
        Integer integer2 = new Integer(string);         //使用构造器
    }
}
