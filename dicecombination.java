import java.util.*;
public class dicecombination {
    static Integer dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new Integer[7][n+1];
        System.out.println(solve(1,n));
    }
    public static int solve(int i, int n){
        if(n==0){
            return 1;
        }
        if(n<0 || i>6){
            return 0;
        }
        if(dp[i][n]!=null){
            return dp[i][n];
        }
        int include = 0;
        include = solve(1,n-i);
        int exclude = solve(i+1,n);
        return dp[i][n] = include + exclude;
    }
}
