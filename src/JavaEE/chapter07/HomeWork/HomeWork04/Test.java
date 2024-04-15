package JavaEE.chapter07.HomeWork.HomeWork04;

public class Test {
    public static void main(String[] args) {
        NormalEmployee normal = new NormalEmployee("打工人", 100, 30,1);
        Manager manager = new Manager("管理人士", 200, 30,1.2);
        normal.printSalary();
        manager.printSalary();
    }
}
