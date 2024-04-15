package JavaEE.chapter09.Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class SuppressWarnings_ {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //1、不希望看到警告信息，可以加入SuppressWarning注解抑制警告信息
        //2、在{""}中，可以写入你希望抑制（不显示）的警告信息
        //3、可以指定很多警告类型
        /*源码
        @Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface SuppressWarnings
         */
        @SuppressWarnings({"unused", "rawtypes"})
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("marry");
        list.add("hello");
        int i = 1;
        System.out.println(list.get(i));
    }
}
