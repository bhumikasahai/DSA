/*import java.util.*;
public class noofpairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = arr[i] + arr[j];
                    if (sum >= l && sum <= r) count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}*/

import java.util.*;
public class noofpairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            Arrays.sort(arr);
            long ans = countPairs(arr, r) - countPairs(arr, l - 1);
            System.out.println(ans);
        }
        sc.close();
    }
    private static long countPairs(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        long cnt = 0;

        while (i < j) {
            if (arr[i] + arr[j] <= target) {
                cnt += (j - i);
                i++;
            } else {
                j--;
            }
        }

        return cnt;
    }
}

