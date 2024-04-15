package JavaEE.chapter07.HomeWork.HomeWork05;

public class Test {
    public static void main(String[] args) {
        new Peasant(100).printSalary();
        new Scientist(100,20).printSalary();
        new Waiter(100).printSalary();
        new Teacher(100,20).printSalary();
    }
}
