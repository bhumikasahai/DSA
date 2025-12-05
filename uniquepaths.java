import java.util.*;
class uniquepaths {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(solve(0, 0, m, n, dp));
        
    }
    public static int solve(int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1) return 1;   
        if(i >= m || j >= n) return 0;      
        if(dp[i][j] != -1) return dp[i][j];
        int right = solve(i, j+1, m, n, dp); 
        int down  = solve(i+1, j, m, n, dp); 
        return dp[i][j] = right + down;
    }    
}
