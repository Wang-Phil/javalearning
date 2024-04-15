package JavaEE.chapter07.Poly.PolyParameter;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAnnual(){
        return salary * 12;
    }

    @Override
    //快捷键 Alt+Insert
    public String toString() {  //重写toString，一般默认是class类名以及属性输出
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
