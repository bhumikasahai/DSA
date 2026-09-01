import java.util.*;
public class sum_digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
    public static int solve(int n){
        if(n <= 9 && n >= 0){
            return n;
        }
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum += digit;
            n = n/10;
        }
        return sum;
    }
}
