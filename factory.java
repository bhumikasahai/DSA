import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class factory{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of machines");
        long n = Integer.parseLong(br.readLine().trim());
        System.out.println("Enter no of product");
        long t = Integer.parseLong(br.readLine().trim());   
        long machines[] = new long[n];
        long mintime = Integer.MAX_VALUE;
        System.out.println("Machines");
        for(int i=0;i<n;i++){
            machines[i] = Integer.parseLong();
            mintime = Math.min(machines[i],mintime);
        }
        long low = 0;
        long high = mintime * t;
        long ans = 0;
        while(low<=high){
            long mid = low + (high-low)/2;
            if(produce(mid,machines,t)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        System.out.println(ans);
    }
    public static boolean produce(long time, long[] machines, long target) {
        long products = 0;
        for (long m : machines) {
            products += time / m;
            if (products >= target) return true; 
        }
        return false;
    }
}