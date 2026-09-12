import java.util.*;
public class lowerbound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int low = 0, high = arr.length - 1;
        int res = arr.length;  
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                res = mid;         
                high = mid - 1;    
            } else {
                low = mid + 1;     
            }
        }
        System.out.println(res);
        sc.close();
    }
}
