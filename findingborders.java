import java.io.*;
import java.util.*;
public class findingborders {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) j++;
            pi[i] = j;
        }
        List<Integer> borders = new ArrayList<>();
        int k = pi[n - 1];
        while (k > 0) {
            borders.add(k);
            k = pi[k - 1];
        }
        Collections.reverse(borders);
        StringBuilder out = new StringBuilder();
        for (int x : borders) out.append(x).append(" ");
        System.out.print(out.toString());
    }
}
