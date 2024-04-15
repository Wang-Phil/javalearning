package JavaEE.chapter07.HomeWork.HomeWork05;

public class Peasant extends Worker{
    public Peasant(double salary) {
        super(salary);
    }

    @Override
    public void printSalary() {
        System.out.println("农民的工资");
        super.printSalary();
    }
}
