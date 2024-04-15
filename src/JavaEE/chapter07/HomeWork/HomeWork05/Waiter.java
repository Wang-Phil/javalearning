package JavaEE.chapter07.HomeWork.HomeWork05;

public class Waiter extends Worker{
    public Waiter(double salary) {
        super(salary);
    }

    @Override
    public void printSalary() {
        System.out.println("服务生");
        super.printSalary();
    }
}
