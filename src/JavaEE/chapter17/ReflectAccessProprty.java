package JavaEE.chapter17;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 22:02
 * 反射操作属性
 */

import java.lang.reflect.Field;

public class ReflectAccessProprty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1. 得到Student 类对应的Class 对象
        Class<?> stuClass = Class.forName("JavaEE.chapter17.Student");
        //2. 创建对象
        Object o = stuClass.newInstance();//o 的运行类型就是Student
        System.out.println(o.getClass());//Student
        //3. 使用反射得到age 属性对象
        Field age = stuClass.getField("age");
        age.set(o,88); //反射操作属性
        System.out.println(age.get(o));

        //4. 使用反射操作name 属性
        Field name = stuClass.getDeclaredField("name");
        //对name 进行暴破, 可以操作private 属性
        name.setAccessible(true);
        name.set(o, "小明");
        System.out.println(name.get(o));
        name.set(null,"小红");//因为name 是static 属性，因此o 也可以写出null
        System.out.println(name.get(o));
        System.out.println(name.get(null));//获取属性值, 要求name 是static
    }
}
class Student {//类
    public int age;
    private static String name;
    public Student() {//构造器
    }
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}