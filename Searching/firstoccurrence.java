import java.util.*;
public class firstoccurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                ans = mid;
                high = mid-1;
            }else if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        System.out.println(ans);
    }
}
