import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
class minicoins{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int target = Integer.parseInt(firstLine[1]);
        int arr[] = new int[n];
        String[] coins = br.readLine().split(" "); 
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(coins[i]);
        }
        int dp[] = new int[target+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        System.out.println(solve(n, target, arr, dp));
    }

    public static int solve(int n, int target, int arr[], int dp[]){
        dp[0] = 0;
        for(int i=1;i<=target;i++){
            for(int j=0;j<n;j++){
                if(i-arr[j]>=0)
                dp[i] = Math.min(dp[i] , 1+dp[i-arr[j]]);           
            }
        }
        if(dp[target]==Integer.MAX_VALUE-1){
            return -1;
        }else{
            return dp[target];
        }
    }
}
