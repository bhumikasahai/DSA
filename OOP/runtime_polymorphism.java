class Maths{
    public int add(int a, int b){
        return a+b;
    }    
}
class AdvanceMaths extends Maths{
    @Override
    public int add(int a, int b){
        return a+b+10;
    }
}
public class runtime_polymorphism {
    public static void main(String[] args) {
        Maths m = new AdvanceMaths();
        System.out.println(m.add(10,20));
    }        
}
