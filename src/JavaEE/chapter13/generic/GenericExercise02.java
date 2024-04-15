package JavaEE.chapter13.generic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack",2900,new MyDate(2000, 5, 9)));
        employees.add(new Employee("jerry",5900,new MyDate(2001, 7, 9)));
        employees.add(new Employee("jack",7900,new MyDate(2000, 2, 9)));
        System.out.println(employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i = o1.getName().compareTo(o2.getName());
                if(i != 0){
                    return i;
                }
                return o1.getBrithday().compareTo(o2.getBrithday());
            }
        });
        System.out.println("排序后=============================");
        System.out.println(employees);
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int compareTo(MyDate d){
        if(year - d.getYear() != 0){
            return year - d.getYear();
        }
        if(month - d.getMonth() != 0){
            return month - d.getMonth();
        }
        return day - d.getDay();
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

class Employee{
    private String name;
    private int sal;
    private MyDate brithday;

    public Employee(String name, int sal, MyDate brithday) {
        this.name = name;
        this.sal = sal;
        this.brithday = brithday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBrithday() {
        return brithday;
    }

    public void setBrithday(MyDate brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", brithday=" + brithday +
                '}';
    }
}
