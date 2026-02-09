import java.io.*;
import java.util.*;

public class productqueries {
    static final int INF = (int) 1e9;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        String tStr = fr.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int n = fr.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = fr.nextInt();

            int q = fr.nextInt();
            int[] queries = new int[q];
            int maxQ = 0;
            for (int i = 0; i < q; i++) {
                queries[i] = fr.nextInt();
                maxQ = Math.max(maxQ, queries[i]);
            }

            int[] dp = new int[maxQ + 1];
            Arrays.fill(dp, INF);
            
            // Base case: 1 is the multiplicative identity (0 steps)
            if (maxQ >= 1) dp[1] = 0; 
            
            // Re-order loops for Unbounded DP efficiency
            // For each value in 'a', update the DP table
            for (int val : a) {
                if (val <= 1) continue; // Skip 0 or 1 to avoid infinite loops/no change
                for (int x = val; x <= maxQ; x++) {
                    if (x % val == 0) {
                        int prev = x / val;
                        if (dp[prev] != INF) {
                            dp[x] = Math.min(dp[x], dp[prev] + 1);
                        }
                    }
                }
            }

            for (int v : queries) {
                out.println(dp[v] >= INF ? -1 : dp[v]);
            }
        }
        out.flush();
    }
}