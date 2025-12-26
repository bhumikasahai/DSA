import java.util.*;

public class StringMatchingSB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pat  = sc.next();

        StringBuilder sb = new StringBuilder();
        sb.append(pat).append('$').append(text);
        String s = sb.toString();

        int n = s.length();
        int[] z = new int[n];

        // Z-algorithm
        for (int i = 1, l = 0, r = 0; i < n; i++) {
            if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                z[i]++;

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        int ans = 0;
        int m = pat.length();

        for (int i = 0; i < n; i++) {
            if (z[i] == m) ans++;
        }

        System.out.println(ans);
    }
}
