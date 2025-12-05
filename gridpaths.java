import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class gridpaths {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(br.readLine().trim());
        char arr[][] = new char[row][row];
        for (int i = 0; i < row; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < row; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        int dp[][] = new int[row][row];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(0, 0, row, row, arr, dp));
    }
    public static int solve(int i, int j, int m, int n, char arr[][], int dp[][]) {
        if (i >= m || j >= n) return 0;
        if (arr[i][j] == '*') return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int right = solve(i, j + 1, m, n, arr, dp) % MOD;
        int down = solve(i + 1, j, m, n, arr, dp) % MOD;
        return dp[i][j] = (right + down) % MOD;
    }
}
// TABULATION

