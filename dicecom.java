import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
class dicecom{
    static final int MOD = 1000000007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long dp[] = new long[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            long ans = 0;
            for(int j = 1; j <= 6; j++){
                if(i - j < 0) continue;
                ans = (ans + dp[i-j]) % MOD;
            }
            dp[i] = (int) ans;
        }

        System.out.println(dp[n]);
    }
}
//MEMOIZATION will not work here