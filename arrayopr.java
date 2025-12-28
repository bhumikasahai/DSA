import java.io.*;
import java.util.*;
public class arrayopr {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(a);
            long score = 0;
            for (int i = 0; i < k; i++) {
                int x = a[n - 2*k + i];
                int y = a[n - k + i];
                score += x / y;
            }
            for (int i = 0; i < n - 2*k; i++) {
                score += a[i];
            }
            System.out.println(score);
        }
    }
}
