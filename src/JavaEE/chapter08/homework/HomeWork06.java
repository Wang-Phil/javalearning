package JavaEE.chapter08.homework;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork06 {
    public static void main(String[] args) {
        new Car(50).new Air().flow();
        new Car(20).new Air().flow();
        new Car(-10).new Air().flow();
    }
}

class Car{
    private int temperature;

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class  Air{
        public void flow(){
            if(temperature > 40){
                System.out.println("吹冷风");
            }
            else if(temperature < 0){
                System.out.println("吹暖风");
            }
            else{
                System.out.println("关闭空调");
            }
        }
    }

}
