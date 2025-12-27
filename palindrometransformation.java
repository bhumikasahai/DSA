import java.io.*;

public class PalindromeTransformation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int p = Integer.parseInt(parts[1]);

        String s = br.readLine();
        char[] c = s.toCharArray();

        if (p > n / 2) p = n - p + 1;   // mirror cursor to left half

        int L = Integer.MAX_VALUE, R = -1;
        int changeCost = 0;

        for (int i = 0; i < n / 2; i++) {
            int diff = Math.abs(c[i] - c[n - i - 1]);
            if (diff != 0) {
                changeCost += Math.min(diff, 26 - diff);
                L = Math.min(L, i + 1);
                R = Math.max(R, i + 1);
            }
        }

        if (R == -1) {     // already palindrome
            System.out.println(0);
            return;
        }

        int moveCost = (R - L) + Math.min(Math.abs(p - L), Math.abs(p - R));

        System.out.println(changeCost + moveCost);
    }
}
