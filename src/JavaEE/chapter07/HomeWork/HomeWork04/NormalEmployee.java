package JavaEE.chapter07.HomeWork.HomeWork04;

public class NormalEmployee extends Empolyee{
    public NormalEmployee(String name, double dairySalary, int workDays, double grades) {
        super(name, dairySalary, workDays, grades);
    }

    @Override
    public void printSalary() {
        //直接调用父类的方法
        super.printSalary();
        System.out.println("普通员工工资为："+getDairySalary()*getWorkDays()*getGrades());
    }
}
