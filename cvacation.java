//MEMOIZATION
import java.util.*;
class cvacation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        //int task = sc.nextInt();
        int arr[][] = new int[row][3];
        for(int i=0;i<row;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[row][4];
        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(solve(0, row, arr, dp));
        sc.close();
    }

    public static int solve(int i,int task,int arr[][],int dp[][]){
        if(i==arr.length) return 0;
        if(dp[i][task] != -1) return dp[i][task];

        int res = 0;
        for(int j=0; j<3; j++){
            if(j != task){
                res = Math.max(res, arr[i][j] + solve(i+1, j, arr, dp));
            }
        }
        return dp[i][task] = res;
    }
}

//TABULATION

