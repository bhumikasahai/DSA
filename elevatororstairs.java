import java.util.*;
public class elevatororstairs {
    static int c;
    static int n;
    static Integer dp[][];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        dp = new Integer[n+1][2];
        int stairs[] = new int[n - 1];
        int elevator[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            stairs[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            elevator[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int ans = Math.min(solve(stairs, elevator, i, 0),solve(stairs, elevator, i, 1));
            System.out.print(ans + " ");
        }
    }
    public static int solve(int stairs[], int elevator[], int i, int flag) {
        if(i == 0){
            if(flag == 0) return 0;
            return c;
        }
        if(dp[i][flag]!=null){
            return dp[i][flag];
        }
        if(flag == 0) {
            int st = solve(stairs, elevator, i - 1, 0) + stairs[i - 1];
            int et = solve(stairs, elevator, i - 1, 1) + stairs[i - 1];
            return dp[i][flag] = Math.min(st, et);
        }
        else {
            int st = solve(stairs, elevator, i - 1, 1) + elevator[i - 1];
            int et = solve(stairs, elevator, i - 1, 0) + c + elevator[i - 1];
            return dp[i][flag] = Math.min(st, et);
        }
    }
}