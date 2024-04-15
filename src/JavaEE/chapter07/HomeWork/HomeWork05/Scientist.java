package JavaEE.chapter07.HomeWork.HomeWork05;

public class Scientist extends Worker{
    private double bonus;
    public Scientist(double salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.println("科学家的工资为"+(getBonus()+getSalary())*365);
    }
}
