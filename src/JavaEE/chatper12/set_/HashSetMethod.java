package JavaEE.chatper12.set_;

import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HashSetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add("tom");
        //1、第一种是否能够添加成功？
        set.add(new Dog("jack"));
        set.add(new Dog("jack"));

        //2、第二种是否可以添加成功？
        set.add(new String("merry"));
        set.add(new String("merry"));

        //解析源码，看到底发生了什么？
    }
}

class Dog{
    String name;

    public Dog(String name) {
        this.name = name;
    }
}
