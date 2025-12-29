import java.io.*;
import java.util.*;
public class rectanglecutting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            boolean ok =
                (a % 2 == 0 && b > 1) ||
                (b % 2 == 0 && a > 1);
            sb.append(ok ? "Yes" : "No").append('\n');
        }
        System.out.print(sb);
    }
}
