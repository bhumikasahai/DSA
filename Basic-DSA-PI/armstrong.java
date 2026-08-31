import java.util.*;
public class armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }    
    public static boolean solve(int n){
        if(n<0) return false;
        int original = n;
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum += digit*digit*digit;
            n = n/10;
        }
        return sum==original;
    }
}
