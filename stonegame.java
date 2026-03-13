import java.util.*;

public class stonegame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            int min = 0, max = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();

                if (arr[i] < arr[min]) min = i;
                if (arr[i] > arr[max]) max = i;
            }

            int l = Math.min(min, max);
            int r = Math.max(min, max);

            int[] dp = new int[3];

            dp[0] = r + 1;               // remove from left
            dp[1] = n - l;               // remove from right
            dp[2] = (l + 1) + (n - r);   // remove both sides

            int ans = Math.min(dp[0], Math.min(dp[1], dp[2]));

            System.out.println(ans);
        }
    }
}