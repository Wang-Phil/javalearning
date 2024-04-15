package JavaEE.chatper12.map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        Employee jack = new Employee("jack",1000,"001");
        Employee jerry = new Employee("jerry",3000,"002");
        Employee lurk = new Employee("luck",5000,"003");
        map.put(jack.getId(),jack);
        map.put(jerry.getId(),jerry);
        map.put(lurk.getId(),lurk);

        Set entrySet = map.entrySet();
        for(Object entry :entrySet){
            Map.Entry mentry = (Map.Entry)entry;
            System.out.println(mentry.getValue());
        }
    }
}

class Employee{
    private String name;
    private int sal;
    private String id;

    public Employee(String name, int sal, String id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id='" + id + '\'' +
                '}';
    }
}
