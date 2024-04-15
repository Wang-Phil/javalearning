package JavaEE.chapter07.HomeWork.HomeWork04;

public class Manager extends Empolyee{
    public Manager(String name, double dairySalary, int workDays, double grades) {
        super(name, dairySalary, workDays, grades);
    }

    @Override
    public void printSalary() {
        System.out.println("经理工资为："+(1000+getDairySalary()*getWorkDays()*getGrades()));
    }
}
