import java.util.*;
public class fairdivision{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            for(int i=0;i<n;i++){
                sum += arr[i];
            }
            if(sum % 2 != 0){
                System.out.println("NO");
                continue;
            }
            int target = sum/2;
            Boolean dp[][] = new Boolean[n][target+1];
            if(solve(arr,0,target,dp)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean solve(int arr[], int i, int target, Boolean dp[][]){
        if(target==0) return true;
        if(i>=arr.length || target<0) return false;
        if(dp[i][target]!=null) return dp[i][target];
        boolean include = solve(arr,i+1,target-arr[i],dp);
        boolean exclude = solve(arr,i+1,target,dp);
        return dp[i][target] = include || exclude;
    }
}