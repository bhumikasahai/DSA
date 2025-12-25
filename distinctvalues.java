import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class distinctvalues {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(n,nums));
    }   
    public static long solve(int n, int nums[]){
        HashSet<Integer> set = new HashSet<>();
        long ans = 0;
        int l = 0;
        for(int r=0;r<n;r++){
            while(set.contains(nums[r])){
                set.remove(nums[l]);
                l++;
            }
            set.add(nums[r]);
            ans = ans + (r-l+1);
        }
        return ans;
    } 
}
