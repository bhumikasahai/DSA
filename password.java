import java.io.*;
public class password {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            pi[i] = j;
        }
        int k = pi[n - 1];
        boolean ok = false;
        for (int i = 0; i < n - 1; i++) {
            if (pi[i] == k) {
                ok = true;
                break;
            }
        }
        while (!ok && k > 0) {
            k = pi[k - 1];

            for (int i = 0; i < n - 1; i++) {
                if (pi[i] == k) {
                    ok = true;
                    break;
                }
            }
        }
        if (k == 0) System.out.println("Just a legend");
        else System.out.println(s.substring(0, k));
    }
}
