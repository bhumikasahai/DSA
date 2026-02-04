import java.util.*;
public class cvacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = sc.nextInt();
        int[][] dp = new int[n][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(solve(0, 3, arr, dp));   
        sc.close();
    }
    public static int solve(int i, int last, int[][] arr, int[][] dp) {
        if (i == arr.length) return 0;
        if (dp[i][last] != -1) return dp[i][last];
        int best = 0;
        for (int j = 0; j < 3; j++) {
            if (j != last) {
                best = Math.max(best, arr[i][j] + solve(i + 1, j, arr, dp));
            }
        }
        return dp[i][last] = best;
    }
}
