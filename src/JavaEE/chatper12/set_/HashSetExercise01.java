package JavaEE.chatper12.set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HashSetExercise01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee01("liuyang", 1000, new MyDate(2001, 01, 01) ));
        hashSet.add(new Employee01("liuyang", 1000, new MyDate(2001, 01, 01) ));
        hashSet.add(new Employee01("yicheng", 1000, new MyDate(2001, 01, 01) ));
        System.out.println(hashSet.size());
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}


class Employee01{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee01(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee01 that = (Employee01) o;
        return Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}
