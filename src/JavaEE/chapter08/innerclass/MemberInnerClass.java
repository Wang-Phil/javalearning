package JavaEE.chapter08.innerclass;

/**
 * 成员内部类的使用
 */
    public class MemberInnerClass {
        public static void main(String[] args) {
            Outer08 outer08 = new Outer08();
            outer08.t1();

            //外部其他类，访问成员内部类的两种种方式；
            //第一种方式：把内部类当做外部类的一个成员来使用
            Outer08.Inner08 inner08 = outer08.new Inner08();
            inner08.say();

            //第二种方式，在Outer里面创建一个方法，这个方法返回一个内部类地址
            Outer08.Inner08 inner081 = outer08.getInner08Instance();
            inner081.say();

        }
    }

    class Outer08{
        private int n1 = 10;
        public String name = "张三";
        //1、内部类是定义在外部类的成员位置
        //2、可以用public、private、protected修饰
        //3、作用域在整个类体
        class Inner08{//成员内部类
            public void say(){
                //4、可以访问外部类的所有成员，包含私有的
                System.out.println("n1 = "+n1 + " name = "+name);
            }
        }

        public void t1(){
            //5、外部类使用内部类，创建对象，使用他的成员即可
            Inner08 inner08 = new Inner08();
            inner08.say();
        }

        public Inner08 getInner08Instance(){
            return new Inner08();
        }
    }
