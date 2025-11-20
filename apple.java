import java.util.*;
public class apple {
    static int n;
    static long total;
    static long arr[];
    static long ans = Long.MAX_VALUE;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();
            total += arr[i];
        }  
        divide(0,0);
        System.out.println(ans);
        sc.close(); 
    }
    public static void divide(int i, long sumA){
        if(i==n){
            long diff = Math.abs(total - (2*sumA));
            ans = Math.min(diff,ans);
            return;
        }
        divide(i+1,sumA+arr[i]);
        divide(i+1,sumA);
    }
}
