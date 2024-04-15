package JavaEE.chapter07.HomeWork.HomeWork04;

public class Empolyee {
    private String name;
    private double dairySalary;
    private int workDays;
    private double grades;

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    public Empolyee(String name, double dairySalary, int workDays, double grades) {
        this.name = name;
        this.dairySalary = dairySalary;
        this.workDays = workDays;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDairySalary() {
        return dairySalary;
    }

    public void setDairySalary(double dairySalary) {
        this.dairySalary = dairySalary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public void printSalary(){
        System.out.println("员工工资为：" + workDays * dairySalary * grades);
    }
}
