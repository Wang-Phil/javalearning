package JavaEE.chapter07.HomeWork;

import javax.sql.rowset.spi.SyncResolver;

public class HomeWork01 {
    public static void main(String[] args) {
        Person person[] = new Person[3];
        person[0] = new Person("小明", "程序员", 20);
        person[1] = new Person("小红", "设计师", 25); // 初始化其他元素
        person[2] = new Person("小刚", "工程师", 22); // 初始化其他元素
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3 - 1 - i; j++){
                if(person[j].age > person[j+1].age){
                    Person temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }
        }
        System.out.println(person[0] +"\n" + person[1] + "\n" + person[2]);
    }
}

class Person{
    String name;
    String job;
    int age;
    public  Person(){

    }
    public Person(String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
