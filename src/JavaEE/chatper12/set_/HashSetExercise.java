package JavaEE.chatper12.set_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet<>();
        hashSet.add(new Employee("maliang",18));
        hashSet.add(new Employee("smith", 27));
        hashSet.add(new Employee("maliang",18));
        System.out.println(hashSet.size());
        System.out.println("hashSet:"+hashSet);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

