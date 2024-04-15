package JavaEE.chapter11.date1;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Date3Method {
    public static void main(String[] args) {
        //获取日期，不包含时间
        LocalDate ld = LocalDate.now();
        //获取时间，不包含日期
        LocalTime lt = LocalTime.now();
        //获取时间与日期
        LocalDateTime ldt = LocalDateTime.now();
        //采用DateFormat进行格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf.format(ldt);
        //获取年月日
        System.out.println("年:"+ldt.getYear()+" 月："+ldt.getMonth()+" 日："+ldt.getDayOfMonth());
        System.out.println(format);
        //plus或者minus,获取之前或者之后的时间
        LocalDateTime ldt1 = ldt.plusDays(8931);
        LocalDateTime ldt2 = ldt.minusMinutes(21893);
        //判断是否是闰年
        System.out.println(ld.isLeapYear());
    }
}
