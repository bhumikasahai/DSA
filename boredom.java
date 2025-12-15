import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class boredom{
    static long dp[];
    static int max;
    static long value[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] freq = new long[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        max = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            freq[x]++;
            max = Math.max(max, x);
        }
        value = new long[max + 2];
        for (int i = 0; i <= max; i++) {
            value[i] = i * freq[i];
        }
        dp = new long[max + 2];
        Arrays.fill(dp, -1);
        System.out.println(solve(0));
    }
    public static long solve(int i){
        if (i > max) return 0;
        if (dp[i] != -1) return dp[i];
        long skip = solve(i + 1);
        long take = value[i] + solve(i + 2);
        return dp[i] = Math.max(skip, take);
    }
}