package JavaEE.chapter11.StringBuffer01;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class StringBuffer1 {
    public static void main(String[] args) {
        //字符内容存在 char[] value中，可以更改，效率较高
        StringBuffer stringBuffer = new StringBuffer("hello");

        //StringBuffer常用构造器
        //1、创建一个大小为16的char[],用于存放字符内容
        StringBuffer stringBuffer1 = new StringBuffer();

        //2、通过构造器指定char[]大小
        StringBuffer stringBuffer2 = new StringBuffer(100);

        //3、通过给定一个String，创建StringBuffer
        StringBuffer stringBuffer3 = new StringBuffer("123");

        //String与StringBUffer的相互转换
        //1、String转StringBuffer
        //采用构造器方法
        String str = new String("hello");
        StringBuffer stringBuffer4 = new StringBuffer(str);
        //采用append方法
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append(str);

        //2、StringBuffer转为String方法
        //采用构造器方法
        String string = new String(stringBuffer5);
        //采用toString方法
        String string2 = stringBuffer1.toString();


    }
}
