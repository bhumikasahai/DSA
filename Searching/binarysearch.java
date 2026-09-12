import java.util.*;
public class binarysearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        boolean found = false;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                System.out.println(mid);
                found = true;
                break;
            }else if(arr[mid]<target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(found==false){
            System.out.println(-1);
        }
    }
}
