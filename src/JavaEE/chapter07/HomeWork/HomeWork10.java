package JavaEE.chapter07.HomeWork;

import JavaEE.chapter07.Poly.Dog;

import javax.print.Doc;

public class HomeWork10 {

}
class Docter{
    private String name;
    private int age;
    private String job;
    private String gender;
    private double sal;

    public Docter(String name, int age, String job, String gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        //类型不对，返回false
        if(!(obj instanceof Docter)) return false;
        Docter doc = (Docter) obj;
        //对象用equals，基本数据类型可以用==
        return doc.name.equals(this.name) && doc.age == this.age &&
                doc.gender.equals(this.gender) && doc.job.equals(this.job) && this.sal == doc.sal;
    }
}
