import java.util.*;
public class eknapsack2 {
    static int n;
    static Long dp[][];
    static int value[];
    static int wt[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int w = sc.nextInt();
        value = new int[n];
        wt = new int[n];
        int maxprofit = 0;
        for(int i = 0; i < n; i++){
            wt[i] = sc.nextInt();
            value[i] = sc.nextInt();
            maxprofit += value[i];
        }
        int res = -1;
        dp = new Long[n][maxprofit + 1];
        for(int p = 0; p <= maxprofit; p++){
            if(solve(0, p) <= w){
                res = p;
            }
        }
        System.out.println(res);
    }
    public static long solve(int i, int profit){
        if(profit == 0){
            return 0;
        }
        if(i >= n){
            return Long.MAX_VALUE;
        }
        if(dp[i][profit] != null){
            return dp[i][profit];
        }
        long exclude = solve(i + 1, profit);
        long include = Long.MAX_VALUE;
        if(profit >= value[i]){
            long next = solve(i + 1, profit - value[i]);
            if(next != Long.MAX_VALUE){
                include = wt[i] + next;
            }
        }
        return dp[i][profit] = Math.min(include, exclude);
    }
}