import java.util.*;
public class countingnumber {
    static Long[][][][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(solve(b) - solve(a - 1));
    }
    static long solve(long n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        String s = String.valueOf(n);
        int len = s.length();
        memo = new Long[len][11][2][2];
        return dp(s, 0, 10, true, true);
    }
    static long dp(String s, int idx, int prevDigit, boolean isTight, boolean isLeadingZero) {
        if (idx == s.length()) {
            return 1;
        }
        int tightIdx = isTight ? 1 : 0;
        int leadingIdx = isLeadingZero ? 1 : 0;
        if (memo[idx][prevDigit][tightIdx][leadingIdx] != null) {
            return memo[idx][prevDigit][tightIdx][leadingIdx];
        }
        long count = 0;
        int limit = isTight ? s.charAt(idx) - '0' : 9;
        for (int d = 0; d <= limit; d++) {
            boolean nextTight = isTight && (d == limit);
            if (isLeadingZero || d != prevDigit) {
                boolean nextLeadingZero = isLeadingZero && (d == 0);
                count += dp(s, idx + 1, nextLeadingZero ? 10 : d, nextTight, nextLeadingZero);
            }
        }
        return memo[idx][prevDigit][tightIdx][leadingIdx] = count;
    }
}