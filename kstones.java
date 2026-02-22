import java.util.*;
public class kstones {
    static int dp[];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        dp = new int[k+1]; 
        Arrays.fill(dp,-1);
        if(solve(n,k,arr)==1){
            System.out.println("First");
        }else{
            System.out.println("Second");
        }
        sc.close();
    }
    public static int solve(int n,int k,int arr[]){
        if(k==0) return 0;
        if(dp[k] != -1) return dp[k];
        int canWin = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k){
                if(solve(n,k-arr[i],arr)==0){
                    canWin = 1;
                    break;
                }
            }
        }
        return dp[k] = canWin;
    }
}
