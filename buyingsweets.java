import java.util.*;
public class buyingsweets {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int arr[] = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int max = 0;
            for(int i=0;i<arr.length;i++){
                sum += arr[i];
                max = sum/x;
            }
            if(max==n){
                System.out.print(n);
            }else if(max>n){
                System.out.print(max);
            }else{
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
