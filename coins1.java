import java.io.*;
import java.util.*;
public class coins1 {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int sum = 1; sum <= x; sum++) {
            for (int c : coins) {
                if (sum - c >= 0) {
                    dp[sum] = (dp[sum] + dp[sum - c]) % MOD;
                }
            }
        }
        System.out.println(dp[x]);
    }
}
