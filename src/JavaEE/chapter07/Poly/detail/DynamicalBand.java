package JavaEE.chapter07.Poly.detail;

public class DynamicalBand {
    public static void main(String[] args) {
        A a = new B();
        //实现逻辑：a.sum()的运行对象是b，但是b中没有sum方法，所以从父类找，父类的sum方法里面，有个getI方法，这个方法首先看运行对象里面是否有，这里有的话，get的运行对象的i，所以最后的结果是30
        System.out.println(a.sum());
        //实现逻辑：a.sum1()的运行对象是b，但是b中没有sum1方法，所以从父类找，父类的sum1里面有个i，但是属性并没有动态绑定机制，所以直接是采用A父类的i，所以结果是20
        System.out.println(a.sum1());
    }
}

class A{//父类
    public int i = 10;
    public int sum(){
        return getI() + 10;
    }
    public int sum1(){
        return i + 10;
    }
    public int getI(){
        return i;
    }
}

class B extends A{//父类
    public int i = 20;
//    public int sum(){
//        return i + 20;
//    }
//    public int sum1(){
//        return i + 10;
//    }
    public int getI(){
        return i;
    }
}