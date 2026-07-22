import java.util.Scanner;
public class readingbooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        long max = Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(arr[i]>max){
                max=arr[i];
            }
        }
        long ans = 0;
        ans = Math.max(sum,2*max);
        System.out.println(ans);
    }
}
