import java.util.*;
public class searchrotated {
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
        int res = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                res = mid;
            }
            if(arr[low]<=arr[mid]){
                if (arr[low] <= target && target < arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }else{
                if (arr[mid] < target && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
}
