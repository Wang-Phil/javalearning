package JavaEE.chapter17;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 21:03
 * 演示如何通过反射获取类的结构信息
 */

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) {

    }

    //第一组API
    @Test
    public void api_01() throws ClassNotFoundException {
        //得到Class对象
        Class<?> personCls = Class.forName("JavaEE.chapter17.Person");
        //getName:获取全类名
        System.out.println(personCls.getName());
        //getSimpleNmae:获取简单类名
        System.out.println(personCls.getSimpleName());
        //getFields:获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类与父类的属性"+field.getName());
        }
        //getDeclaredFields:获取本类中的所有属性
        Field[] declaredields = personCls.getDeclaredFields();
        for (Field field : declaredields) {
            System.out.println("本类的所有属性"+field.getName());
        }
        //getMethods:获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类与父类的方法"+method.getName());
        }
        //getDeclaredMethods：获取本类的所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("本类的方法"+method.getName());
        }
        //getConstructors:获取本类所有public修饰的构造器
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类所有public构造器"+constructor);
        }
        //getDeclaredConstructors:获取本类的所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("本类的所有构造器"+constructor);
        }
        //getPackage：以Package形式返回包信息
        System.out.println(personCls.getPackage());
        //getSuperClass：以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的class对象"+superclass);
        //getInterfaces：以Class[]返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息"+anInterface);
        }
        //getAnnotations：以Annotation[]形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息="+annotation);
        }
    }

    @Test
    //第二组API
    public void API_02() throws ClassNotFoundException {
        //得到Class对象
        Class<?>personCls = Class.forName("JavaEE.chapter17.Person");
        //getDeclaredFields:获取本类中所有属性
        //规定说明: 默认修饰符是0 ， public 是1 ，private 是2 ，protected 是4 , static 是8 ，final 是16
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName()
                    + " 该属性的修饰符值=" + declaredField.getModifiers()
                    + " 该属性的类型=" + declaredField.getType());
        }
        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName()
                    + " 该方法的访问修饰符值=" + declaredMethod.getModifiers()
                    + " 该方法返回类型" + declaredMethod.getReturnType());
            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型=" + parameterType);
            }
        }

        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("====================");
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//只是输出名
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }
        }
    }
}

class A{
    public String hobby;
    public A(){

    }
    public void hi(){

    }
}

interface IA{

}

interface IB{

}

@Deprecated
class Person extends A implements IA,IB{
    //四种不同类型修饰符的属性
    public String name;
    protected int age;
    String job;
    private double sal;
    public Person(){}
    private Person(String name){}
    public Person(String name, int age, String job, double sal) {}
    //四种不同类型修饰符的方法
    public void m1() {

    }

    protected void m2(){

    }

    void m3(){

    }

    private void m4(){

    }
}