package JavaEE.chapter07.HomeWork.HomeWork13;

public class Teacher extends Person{
    private double work_age;

    public Teacher(String name, char sex, int age, double work_age) {
        super(name,sex,age);
        this.work_age = work_age;
    }
    public double getWork_age() {
        return work_age;
    }

    public void setWork_age(double work_age) {
        this.work_age = work_age;
    }

    public void teach(){
        System.out.println("我来教书");
    }
    public String play(){
        return getName()+"爱玩象棋";
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString()+
                "work_age=" + work_age +
                '}';
    }
}
