import java.io.*;
import java.util.*;
public class countingtowers {
    static final long MOD = 1_000_000_007L;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] q = new int[t];
        int maxN = 0;
        for (int i = 0; i < t; i++) {
            q[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, q[i]);
        }
        dp = new long[maxN + 1][2];
        for (long[] row : dp) Arrays.fill(row, -1);
        StringBuilder sb = new StringBuilder();
        for (int n : q) {
            long ans = (solve(n, 0) + solve(n, 1)) % MOD;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
    static long solve(int n, int s) {
        if (dp[n][s] != -1) return dp[n][s];
        if (n == 1) return dp[n][s] = 1;      
        long res;
        if (s == 0) {
            res = (2 * solve(n - 1, 0) + solve(n - 1, 1)) % MOD;
        } else { 
            res = (solve(n - 1, 0) + 4 * solve(n - 1, 1)) % MOD;
        }
        return dp[n][s] = res;
    }
}

