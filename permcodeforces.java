import java.util.*;
public class permcodeforces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(i).append(" ");
                sb.append(n + 2 * i - 1).append(" ");
                sb.append(n + 2 * i).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        sc.close();
    }
}   

