import java.util.Arrays;
class Solution {
    int dp[][][];
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int [n][n+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(nums,0,-1)[1];        
    }
    public int[] solve(int nums[], int i, int j){
        if(i==nums.length){
            return new int []{0,1} ;
        }
        if(dp[i][j+1][0] != -1){
            return dp[i][j+1];
        }
        int include[] = {0,0} ;
        if(j == -1 || nums[i]>nums[j]){
            int res[] = solve(nums,i+1,i);
            include[0] = 1 + res[0];
            include[1] = res[1];
        }
        int result[] = new int[2];
        int exclude[] = (solve(nums,i+1,j));
        if(include[0]>exclude[0]){
            result = include;
        }else if(exclude[0]>include[0]){
            result = exclude;
        }else{
            result[0] = include[0];
            result[1] = include[1]+exclude[1];
        }
        return dp[i][j+1] = result;
    }
}