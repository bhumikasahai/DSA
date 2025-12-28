import java.io.*;
import java.util.*;
public class removingdigits {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;

        for (int x = 1; x <= n; x++) {
            int t = x;
            while (t > 0) {
                int d = t % 10;
                t /= 10;
                if (d == 0) continue;
                dp[x] = Math.min(dp[x], dp[x - d] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
