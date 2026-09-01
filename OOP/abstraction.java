abstract class Vehicle {
    abstract void start();
    void stop() {
        System.out.println("Vehicle Stopped");
    }
}
class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car Started");
    }
}
public class abstraction {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
        v.stop();
    }
}