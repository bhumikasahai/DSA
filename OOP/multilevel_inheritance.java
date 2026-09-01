class Vehicle {
    public static void start(){
        System.out.println("Vehicle Started");
    }
    public static void stop(){
        System.out.println("Vehicle stopped");
    }
} 
class Car extends Vehicle {
    public void carType() {
        System.out.println("This is a Car");
    }
} 
class SportsCar extends Car {
    public void sportsCarType() {
        System.out.println("This is a Sports Car");
    }
}
public class multilevel_inheritance {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();
        c.carType();
        SportsCar sc = new SportsCar();
        sc.sportsCarType();    
    }
}
