package JavaEE.chapter07.HomeWork.HomeWork13;

public class Student extends Person{
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name,sex,age);
        this.stu_id = stu_id;
    }
    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void study(){
        System.out.println("学生在学习");
    }

    public String play(){
        return getName()+"爱玩足球";
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "stu_id='" + stu_id + '\'' +
                '}';
    }
}
