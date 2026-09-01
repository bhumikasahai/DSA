interface Vehicle{
    void start();
    void stop();
}
interface Engine{
    void engineType();
}
class Car implements Vehicle,Engine{
    public void start(){
        System.out.println("Car Started");
    }
    public void stop(){
        System.out.println("Car started");
    }
    public void engineType() {
        System.out.println("Car has a powerful engine");
    }
    public void carType() {
        System.out.println("This is a Car");
    }
}
public class multiple_inheritance {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();
        c.engineType(); 
        c.carType();   
    }
}
