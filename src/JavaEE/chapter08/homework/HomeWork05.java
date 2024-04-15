package JavaEE.chapter08.homework;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork05 {
    public static void main(String[] args) {
        Person tangsen = new Person("唐僧", new Horse());
        tangsen.passRoad();
        tangsen.passRiver();
        tangsen.passFire();
    }
}

interface Vehicles{
    public void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般的时候走路的时候过马路");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("特殊的时候过河的时候用船");
    }
}

class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("过火焰山的时候用飞机");
    }
}

class VehiclesHouse {
    //static方便
    //马不变

    private VehiclesHouse() {
    }

    private static Horse hosrse = new Horse();
    public static Horse getHorse(){
       return hosrse;
    }

    public static Boat getBoat(){
       return new Boat();
    }

    public static Plane getPlane(){
        return new Plane();
    }
}

class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRoad(){
        if(vehicles == null) {
            vehicles = VehiclesHouse.getHorse();
        }
        vehicles.work();
    }

    public void passRiver(){
        //判断是否为空，不是船
        if(!(vehicles instanceof Boat)) {
            vehicles = VehiclesHouse.getBoat();
        }
        vehicles.work();
    }

    public void passFire(){
        //判断是否为空，不是船
        if(!(vehicles instanceof Plane)){
            vehicles = VehiclesHouse.getPlane();
        }
        vehicles.work();
    }

}