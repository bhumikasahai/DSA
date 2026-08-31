import java.util.*;
public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }   
    
    //BRUTE
    //public static int solve(int n){
    //    if(n==0 || n==1){
    //        return 1;
    //    }
    //    int fact = 1;
    //    for(int i=2;i<=n;i++){
    //        fact = fact*i;
    //    }
    //    return fact;
    //}

    //OPTIMAL
    public static int solve(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*solve(n-1);
    }
}
