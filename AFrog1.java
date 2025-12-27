import java.util.*;
class AFrog1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n];
        Arrays.fill(dp,-1);  
        System.out.println(solve(0,n,arr,dp));   
        sc.close();
    }
    public static int solve( int i, int n,int arr[], int dp[]){
        if(i==n-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int oj = Math.abs(arr[i]-arr[i+1]) + solve(i+1,n,arr,dp);
        int tj = Integer.MAX_VALUE;
        if(i+2<n){
            tj = Math.abs(arr[i]-arr[i+2]) + solve(i+2,n,arr,dp);
        }
        return dp[i] = Math.min(oj,tj);
    }
}