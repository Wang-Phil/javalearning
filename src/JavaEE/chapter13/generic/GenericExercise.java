package JavaEE.chapter13.generic;

import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class GenericExercise {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("jack", 18));
        students.add(new Student("tom", 28));
        students.add(new Student("mary", 19));

        //增强for循环遍历
        for(Student s : students){
            System.out.println(s);
        }

        //public class HashMap<K,V> ,这里String -> K  , Student -> V
        HashMap<String, Student> hashMap = new HashMap<String, Student>();
        hashMap.put("jack",new Student("jack", 18));
        hashMap.put("tom", new Student("tom", 28));
        hashMap.put("mary",new Student("mary", 19));

        //迭代器遍历
        //public Set<Map.Entry<K,V>> entrySet() ，这里String -> K  , Student -> V
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        // public final Iterator<Map.Entry<K,V>> iterator()，这里String -> K  , Student -> V
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next);
        }

        List<Map> listMaps = new ArrayList<>();
        listMaps.add(new HashMap());        //可以传入该其子类类型

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<>();    //推荐这种，方便
        List arrayList = new ArrayList();       //默认泛型为<E> 即Object

    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

