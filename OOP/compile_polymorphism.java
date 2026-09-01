class Add {
    public static int add(int a, int b){
        return a+b;
    }
    public static int add(int a, int b, int c){
        return a+b+c;
    }
}  
public class compile_polymorphism {
    public static void main(String[] args) {
        Add a = new Add();
        System.out.println(a.add(10, 20));
        System.out.println(a.add(10, 20, 30));
    }    
}
