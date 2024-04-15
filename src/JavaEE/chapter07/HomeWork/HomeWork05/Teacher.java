package JavaEE.chapter07.HomeWork.HomeWork05;

public class Teacher extends Worker{
    private double lessonSalary;
    public Teacher(double salary, double lessonSalary) {
        super(salary);
        this.lessonSalary = lessonSalary;
    }

    public double getLessonSalary() {
        return lessonSalary;
    }

    public void setLessonSalary(double lessonSalary) {
        this.lessonSalary = lessonSalary;
    }

    @Override
    public void printSalary() {
        System.out.println("老师的工资为：" + (getLessonSalary()*365+getSalary()*365));
    }
}
