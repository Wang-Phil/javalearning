package JavaEE.chatper02;

//引用包的语法：import+包的名字
import java.util.Scanner;       //只是引用一个类Scanner
import java.util.*;             //引用java.util的所有包

public class changeKind {
    //main模板快捷键
    public static void main(String[] args) {
   /*     //sout模版快捷键
        System.out.println();
        //fori模版快捷键
        for (int i = 0; i < ; i++) {
            
        }*/
        Person p = new Person("小明", 20);
        //hashcode可以近似表示对象的地址，可以输出this和当前对象的hashcode看看对象是否一样
        System.out.println("person的地址："+p.hashCode());
        //输出：person的地址：1163157884
        p.info();
        //输出：小明当前对象的hashcode是1163157884
        //说明this指向当前对象，哪个对象调用，this就代表哪个对象
    }
}
//类person
class Person{
    int age = 90;
    String name;
    //构造器
    Person(String n, int a){
        name = n;       //给属性赋值
        age = a;
    }
    public void info(){
        System.out.println(this.name+"当前对象的hashcode是"+this.hashCode());
    }
}

class T{
    public  T(){
        //必须放在第一条语句，在一个构造器中访问另外一个构造器
        this("jack",100);
        System.out.println("T()构造器");
    }

    public T(String name, int age){
        System.out.println("T(String name, int age)构造器");
    }
}

