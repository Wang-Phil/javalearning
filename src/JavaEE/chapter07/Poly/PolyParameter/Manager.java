package JavaEE.chapter07.Poly.PolyParameter;

public class Manager extends Employee{
    double bonus;

    public Manager(String name, double salary, double bouns) {
        super(name, salary);
        this.bonus = bouns;
    }

    public void manage(){
        System.out.println("经理" + this.getName() + "管理员工");
    }
    public double getAnnual(){
        return super.getAnnual() + bonus;
    }
}
