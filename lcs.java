import java.util.*;
public class lcs {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();
        dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        solve(a, b, n, m);
        List<Integer> lcs = build(a, b, n, m);
        System.out.println(lcs.size());
        for (int x : lcs) System.out.print(x + " ");
        sc.close();
    }
    public static int solve(int[] a, int[] b, int n, int m) {
        if (n == 0 || m == 0) return dp[n][m] = 0;   
        if (dp[n][m] != -1) return dp[n][m];
        if (a[n - 1] == b[m - 1])
            return dp[n][m] = 1 + solve(a, b, n - 1, m - 1);
        return dp[n][m] =
            Math.max(solve(a, b, n - 1, m),
                     solve(a, b, n, m - 1));
    }
    public static List<Integer> build(int[] a, int[] b, int n, int m) {
        List<Integer> seq = new ArrayList<>();
        while (n > 0 && m > 0) {
            if (a[n - 1] == b[m - 1]) {
                seq.add(a[n - 1]);
                n--; 
                m--;
            } else if (dp[n - 1][m] >= dp[n][m - 1]) {
                n--;
            } else {
                m--;
            }
        }
        Collections.reverse(seq);
        return seq;
    }
}
