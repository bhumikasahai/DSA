import java.util.*;
public class gone {
    static int[][][] dp;
    static char[] digits;
    static boolean[] isPrime = new boolean[82];
    static int solve(long num) {
        if (num < 0) return 0;
        digits = Long.toString(num).toCharArray();
        int len = digits.length;
        dp = new int[len][82][2];
        for (int i = 0; i < len; i++)
            for (int j = 0; j <= 81; j++)
                Arrays.fill(dp[i][j], -1);
        return dfs(0, 0, 1);
    }
    static int dfs(int pos, int sum, int tight) {
        if (pos == digits.length) {
            return isPrime[sum] ? 1 : 0;
        }
        if (dp[pos][sum][tight] != -1) {
            return dp[pos][sum][tight];
        }
        int limit = (tight == 1) ? digits[pos] - '0' : 9;
        int ans = 0;
        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            ans += dfs(pos + 1, sum + d, newTight);
        }
        dp[pos][sum][tight] = ans;
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
    }
}
