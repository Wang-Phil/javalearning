package JavaEE.chapter11.StringBuffer01;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class StringBufferMethods {
    public static void main(String[] args) {
        //增,append里面的参数类型可以多种
        StringBuffer s = new StringBuffer("hello");
        s.append("一号").append(105);
        System.out.println(s);

        //删，delete删除从某个索引到另外一个索引之间的值,左闭右开
        s.delete(3,5);
        System.out.println(s);

        //改，replace，替换索引之间的值
        s.replace(1,5,"中国航天");
        System.out.println(s);

        //查，indexOf，查找子串在字符串第一次出现的索引，找不到就返回-1
        int index = s.indexOf("中国");
        System.out.println(index);

        //插入，insert，从某个下标插入字符串
        s.insert(5,"牛逼");
        System.out.println(s);

        //获取长度，length
        System.out.println(s.length());
    }
}
