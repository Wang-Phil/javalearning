package JavaEE.chapter11.date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Date1Method {
    public static void main(String[] args) throws ParseException {
        //获取当前的时间，但是格式是美国格式，需要根据中文的格式进行匹配
        Date d1 = new Date();
        //指定毫秒数获取时间,从1970-01-01开始计算
        Date d2 = new Date(13223);
        System.out.println(d2);
        //中文格式，指定格式,字符根据jdk官方文档进行查询，不能乱写
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日 hh:mm:ss E");
        String format = sdf.format(d1);     //将英文格式转换为中文格式
        System.out.println("当前的格式为"+format);
        //将string转为日期格式，parse函数
        String s = "1996 年 01 月 01 日 10:20:30 星期一";
        Date parse = sdf.parse(s);
        System.out.println("parse=" + sdf.format(parse));
    }
}
