import java.io.*;
import java.util.*;
public class twosets {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 1L * n * (n + 1) / 2;
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (sum % 2 != 0) {
            sb.append("NO\n");
        } else {
            sb.append("YES\n");
            long target = sum / 2;
            for (int i = n; i >= 1; i--) {
                if (i <= target) {
                    target -= i;
                    set1.add(i);
                } else {
                    set2.add(i);
                }
            }
            sb.append(set1.size()).append("\n");
            for (int x : set1) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            sb.append(set2.size()).append("\n");
            for (int x : set2) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}