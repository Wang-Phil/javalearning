package JavaEE.chapter07.Poly.PolyParameter;

public class Test {
    public static void main(String[] args) {
        Employee manager = new Manager("经理",10000,200000);
        Employee worker = new Worker("小员工",5000);
        Test test = new Test();
        test.showEmpAnnual(manager);
        test.showEmpAnnual(worker);
        test.testWork(manager);
        test.testWork(worker);
        "abc".equals("ab");
        System.out.println(manager.toString());
        System.out.println(manager);
    }

    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e){
        if(e instanceof Worker){
            ((Worker) e).Work();
        }
        else if(e instanceof Manager){
            ((Manager)e).manage();
        }
    }
}
