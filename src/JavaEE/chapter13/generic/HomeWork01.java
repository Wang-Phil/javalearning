package JavaEE.chapter13.generic;

import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork01 {
    public static void main(String[] args) {
        Dao<User> userDao = new Dao<>();
        userDao.save("1", new User("1",18, "wangYang"));
        userDao.save("2", new User("2",19, "liuYang"));
        userDao.save("3", new User("3",20, "heiYang"));
        userDao.save("4", new User("4",21, "baiYang"));
        System.out.println(userDao.get("2"));
        userDao.update("3",new User("3",22000, "heiYang"));
        userDao.delete("4");
        System.out.println(userDao.list());

    }
}

class Dao<T>{
    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity){
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id, T entity){
        map.put(id, entity);
    }

    public List<T> list(){
        ArrayList<T> users = new ArrayList<>();
        Collection<T> values = map.values();
        for(T user : values){
            users.add(user);
        }
        return users;
    }

    public void delete(String id){
        map.remove(id);
    }
}

class User{
    private String id;
    private int age;
    private String name;

    public User(String id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}