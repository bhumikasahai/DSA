import java.io.*;
import java.util.*;
class bookshop {
    static int n;
    static int dp[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int prices[] = new int[n];
        int pages[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        } 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n + 1][x + 1];
        for (int i = 1; i <= n; i++) {
            for (int target = 0; target <= x; target++) {
                int exclude = dp[i - 1][target];
                int include = 0;
                if (prices[i - 1] <= target) {
                    include = pages[i - 1] + dp[i - 1][target - prices[i - 1]];
                }
                dp[i][target] = Math.max(include, exclude);
            }
        }
        System.out.println(dp[n][x]);
    }
}