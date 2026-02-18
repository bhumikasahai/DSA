import java.util.*;
public class checkoutassistant {
    static int m;
    static int time[];
    static int cost[];
    static long dp[][];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        time = new int[m];
        cost = new int[m];
        dp = new long[m+1][m+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<m;i++){
            time[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }
        System.out.println(solve(0,m));
        sc.close();
    }  
    public static long solve(int i, int n){
        if(n<=0){
            return 0;
        }
        if(i>=m){
            return Integer.MAX_VALUE;
        }
        if(dp[i][n] != -1) return dp[i][n];
        long include = (long)cost[i] + solve(i+1,n-(time[i]+1));
        long exclude = solve(i+1,n);
        return dp[i][n] = Math.min(include,exclude);
    }  
}
