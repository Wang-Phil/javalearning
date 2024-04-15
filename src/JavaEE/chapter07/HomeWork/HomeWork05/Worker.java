package JavaEE.chapter07.HomeWork.HomeWork05;

public class Worker {
    private double salary;

    public Worker(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printSalary(){
        System.out.println("工资为：" + salary * 365);
    }
}
