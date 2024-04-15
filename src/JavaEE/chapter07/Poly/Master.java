package JavaEE.chapter07.Poly;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //使用多态机制如何书写
    public void feed(Animal animal, Food food){
        System.out.println("主人" + name + "给" + "小狗" + animal.getName() + "喂食" + food.getName());
    }

//    //完成主人给宠物喂食,给小狗喂骨头
//    public void feed(Dog dog, Bone bone){
//        System.out.println("主人" + name + "给" + "小狗" + dog.getName() + "喂食" + bone.getName());
//    }
    //给猫喂鱼
}
