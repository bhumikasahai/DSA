import java.io.*;
import java.util.*;
public class knapsack1 {
    static int n;
    static int[] wt, val;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        wt = new int[n];
        val = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            wt[i] = Integer.parseInt(st.nextToken());
            val[i] = Integer.parseInt(st.nextToken());
        }
        dp = new long[n + 1][W + 1];
        for (long[] row : dp) Arrays.fill(row, -1);
        System.out.println(solve(0, W));
    }
    static long solve(int i, int w) {
        if (i == n) return 0;             
        if (dp[i][w] != -1) return dp[i][w];
        long best = solve(i + 1, w);       
        if (wt[i] <= w) {                  
            best = Math.max(best, val[i] + solve(i + 1, w - wt[i]));
        }
        return dp[i][w] = best;
    }
}
