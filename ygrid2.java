import java.io.*;
import java.util.*;
public class ygrid2 {
    static final long MOD = 1_000_000_007;
    static int h, w;
    static char[][] grid;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        grid = new char[h][w];
        for (int i = 0; i < h; i++) grid[i] = br.readLine().toCharArray();
        dp = new long[h][w];
        for (long[] row : dp) Arrays.fill(row, -1);
        System.out.println(solve(h - 1, w - 1));
    }
    public static long solve(int i, int j){
        if(i<0 || j<0){
            return 0;
        }
        if(grid[i][j]=='#'){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        long right = solve(i,j-1);
        long down = solve(i-1,j);
        return dp[i][j] = (right+down) % MOD;
    }
}

