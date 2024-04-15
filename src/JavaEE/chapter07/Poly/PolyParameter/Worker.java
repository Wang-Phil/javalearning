package JavaEE.chapter07.Poly.PolyParameter;

public class Worker extends Employee{

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void Work(){
        System.out.println("员工"+getName()+"正在好好工作");
    }

    public double getAnnual(){
        return super.getAnnual();
    }


}
