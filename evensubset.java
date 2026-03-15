import java.util.*;
public class evensubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            String result = solve(arr, 0, 0, "", 0);
            System.out.println(result);
        }
        sc.close();
    }
    public static String solve(int arr[], int i, int currentSum, String indices, int count) {
        if (currentSum > 0 && currentSum % 2 == 0) {
            return count + "\n" + indices.trim(); 
        }
        if (i == arr.length) {
            return "-1";
        }
        String ans = "-1";
        String include = solve(arr, i + 1, currentSum + arr[i], indices + (i + 1) + " ", count + 1);
        if (!include.equals("-1")) {
            ans = include;
            return ans; 
        }
        String exclude = solve(arr, i + 1, currentSum, indices, count);
        if (!exclude.equals("-1")) {
            ans = exclude;
        }
        return ans;
    }
}