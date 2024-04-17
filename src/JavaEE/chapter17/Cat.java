package JavaEE.chapter17;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/17
 *Time: 14:44
 */

public class Cat {
    private String name;
    public int age;
    public Cat() {}
    public Cat(String name){
        this.name = name;
    }
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void hi(){
//        System.out.println("hi");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Cry(){
        System.out.println("猫猫在哭");
    }
}
