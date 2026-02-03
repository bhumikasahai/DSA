import java.util.*;

public class gone { // SPOJ usually requires the class to be 'Main'
    static int[][][] dp;
    static char[] digits;
    static boolean[] isPrime = new boolean[82];

    // Helper to pre-calculate primes up to the max possible sum (9 * 9 = 81)
    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= 81; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= 81; i += p)
                    isPrime[i] = false;
            }
        }
    }

    static int solve(long num) {
        if (num < 0) return 0;
        if (num == 0) return 0; // 0 sum is not prime
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
            // tight stays 1 only if we were already tight and we pick the limit digit
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            ans += dfs(pos + 1, sum + d, newTight);
        }
        return dp[pos][sum][tight] = ans;
    }

    public static void main(String args[]) {
        sieve();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                long l = sc.nextLong();
                long r = sc.nextLong();
                // Range [L, R] is solve(R) - solve(L-1)
                System.out.println(solve(r) - solve(l - 1));
            }
        }
        sc.close();
    }
}