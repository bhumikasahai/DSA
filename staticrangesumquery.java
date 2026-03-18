import java.util.*;
public class staticrangesumquery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        long prefix[] = new long[n + 1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        while(q-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            long ans = prefix[r] - prefix[l - 1];
            System.out.println(ans);
        }
    }
}