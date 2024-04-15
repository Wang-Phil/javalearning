package JavaEE.chapter15.obejctStream;

import java.io.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ObjectInputAndOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        //序列化
        String filePath = "d:\\data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化数据到 e:\data.dat
        oos.writeInt(100);// int -> Integer (实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("韩顺平教育");//String
        //保存一个dog 对象
        oos.writeObject(new Dog("旺财", 10));
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");

        //反序列化
        // 1.创建流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\data.dat"));
        // 2.读取， 注意顺序,顺序与读取的顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        System.out.println((Dog)ois.readObject());

        // 3.关闭
        ois.close();
        System.out.println("以反序列化的方式读取(恢复)ok~");
    }
}

class Dog implements Serializable{  //必须实现序列化接口才能调用Object对象流
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}