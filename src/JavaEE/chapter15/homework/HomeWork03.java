package JavaEE.chapter15.homework;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Properties;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\dog.properties"));
        Dog dog = new Dog(properties.getProperty("name"),Integer.parseInt(properties.getProperty("age")),properties.getProperty("color"));
        System.out.println(dog);

        String filePath = "d:\\dog.dat";
        ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(filePath));
        oot.writeObject(dog);
        oot.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        System.out.println((Dog)ois.readObject());

    }
}
class Dog implements Serializable {
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
