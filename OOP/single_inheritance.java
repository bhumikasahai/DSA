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
class Bike extends Vehicle {
    public void bikeType() {
        System.out.println("This is a Car");
    }
}  
public class single_inheritance{
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();
        c.carType();
        Bike b = new Bike();
        b.start();
        b.stop();
        b.bikeType();
    }
}


