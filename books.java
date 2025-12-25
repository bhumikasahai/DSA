import java.util.*;
public class books {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int sum = 0;
        int l = 0;
        int maxLen = 0;
        int r = 0;
        while(r<n){
            sum += nums[r];
            while(sum>t){
                sum -= nums[l];
                l++;
            }
            if(sum<=t){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        System.out.println(maxLen);
        sc.close();
    }
}
