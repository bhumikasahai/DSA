import java.util.*;
public class linear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        boolean found = false;
        for(int i = 0; i < n; i++) {
            if(arr[i] == target) {
                System.out.println(i);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println(-1);
        }
    }
}
