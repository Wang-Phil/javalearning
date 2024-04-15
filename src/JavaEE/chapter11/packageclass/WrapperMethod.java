package JavaEE.chapter11.packageclass;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class WrapperMethod {
    public static void main(String[] args) {
        //Integer和Character类一些常用的方法
        System.out.println(Integer.MAX_VALUE);      //最大值
        System.out.println(Integer.MIN_VALUE);      //最小值
        System.out.println(Character.isDigit('a'));     //是否是数字
        System.out.println(Character.isLetter('a'));    //是否是字母
        System.out.println(Character.isUpperCase('a')); //是否是大写
        System.out.println(Character.isLowerCase('a')); //是否是小写
    }
}
