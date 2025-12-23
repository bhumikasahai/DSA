import java.util.*;
public class cutribbon{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[3];
        for(int i=0;i<3;i++){
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[3][n+1];
        for(int i=0;i<3;i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(arr,n,0,dp));
        sc.close();
    }
    public static int solve(int arr[], int n, int i,int dp[][]){
        if(n==0){
            return 0;
        }
        if(i==arr.length){
            return Integer.MIN_VALUE;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        if(dp[i][n] != -1) return dp[i][n];
        int include = Integer.MIN_VALUE;
        if(arr[i]<=n){
            include = 1 + solve(arr,n-arr[i],i,dp);
        }
        int exclude = solve(arr,n,i+1,dp);
        return dp[i][n] = Math.max(include,exclude);
    }
}