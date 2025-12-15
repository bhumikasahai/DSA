import java.util.*;
class knapsack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val[] = new int[n];
        int wt[] = new int[n];
        for(int i=0;i<n;i++){
            val[i] = sc.nextInt();
        }
    }   
    public static int solve(int val[], int wt[], int target, int i, int sum){
        if(target>0) return 0;
        if(target==0){
            return sum;
        }
        int include = solve(val,wt,target-wt[i],i+1,sum + val[i]);
        int exclude = solve(val,wt,target,i+1, sum+val[i]); 
        return Math.max(include,exclude); 
    } 
}