import java.util.*;
public class hitthelottery{
    static int dp[][];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int arr[] = {1,5,10,20,100};
        int target = sc.nextInt();
        dp = new int[n+1][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(solve(0,target,arr));
    }
    public static int solve(int i, int target, int arr[]){
        if(target==0){
            return 0;
        }
        if(i>=arr.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][target] !=-1) return dp[i][target];
        int include = Integer.MAX_VALUE;
        if(arr[i]<=target){
            int res = solve(i,target-arr[i],arr);
            if(res != Integer.MAX_VALUE){
                include = 1 + res;
            }
        }
        int exclude = solve(i+1,target,arr);
        return dp[i][target] = Math.min(include,exclude);
    }
}