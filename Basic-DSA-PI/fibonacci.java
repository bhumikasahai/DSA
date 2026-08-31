import java.util.*;
public class fibonacci{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //solve(n);
        for(int i=0;i<n;i++){
            System.out.print(solve(i)+" ");
        }
    }

    //ITERATIVE
    //public static void solve(int n){
    //    int a = 0;
    //    int b = 1;
    //    for(int i=1;i<n;i++){
    //        System.out.print(a + " ");
    //        int next = a+b;
    //        a = b;
    //        b=next;
    //    }
    //    System.out.println();
    //}

    //RECURSIVE
    public static int solve(int n){
        if(n==0){
            return 0;    
        }
        if(n==1){
            return 1;
        }
        return solve(n-1)+solve(n-2);
    }
}