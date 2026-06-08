import java.util.*;
public class missingnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n - 1];
        long arrsum = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
            arrsum += arr[i];
        }
        long sum = (long)n * (n + 1) / 2;
        System.out.println(sum - arrsum);
    }
}