import java.util.*;
public class maximumincrease{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr,1,1));
    }
    public static int solve(int arr[], int i, int count){
        if(i==arr.length){
            return count;
        }
        if(i+1<arr.length && arr[i-1]<arr[i]){
            return Math.max(count+1,solve(arr,i+1,count+1));
        }else{
            return Math.max(count,solve(arr,i+1,1));
        }
    }
} 