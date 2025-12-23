import java.util.*;
public class editdistance{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int lcs =  solve(s1,s2,n,m,dp);
        System.out.println(lcs);
        sc.close();
    }
    public static int solve(String s1, String s2, int n, int m, int dp[][]){
        if(n==0){
            return m;
        }    
        if(m==0){
            return n;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m] = solve(s1,s2,n-1,m-1,dp);
        }else {
            int replace = solve(s1, s2, n - 1, m - 1, dp);
            int delete = solve(s1, s2, n - 1, m, dp);
            int insert = solve(s1, s2, n, m - 1, dp);
            return dp[n][m] = 1 + Math.min(replace, Math.min(delete, insert));
        }
    }
}