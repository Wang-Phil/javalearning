package JavaEE.chapter07.Poly;

public class Poly01 {
    public static void main(String[] args) {
        Master tom = new Master("汤姆");
        Dog dog =  new Dog("小黄狗");
        Bone bone = new Bone("大骨头");
        tom.feed(dog, bone);
    }
}
