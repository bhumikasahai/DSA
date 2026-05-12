import java.util.*;
public class oeisproblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long cur = 1;
            for (int i = 1; i <= n; i++) {
                System.out.print(cur + " ");
                cur *= (i + 1);
            }
            System.out.println();
        }
        sc.close();
    }
}
