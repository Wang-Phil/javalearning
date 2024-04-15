package JavaEE.chapter07.Poly.detail;


public class Test {
    public static void main(String[] args) {
        Animal animal = new Cat();
        //无法解析Car中独有的方法和属性
//        animal.special();
//        animal.age;
        //重写，首先是先找car里面有的方法
        animal.eat();
        Cat cat = (Cat)animal;
        System.out.println(animal.age);
        System.out.println(cat.age);

    }
}
