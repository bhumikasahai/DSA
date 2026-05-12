import java.util.*;
public class contest23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            List<Integer> div6 = new ArrayList<>();
            List<Integer> div2 = new ArrayList<>();
            List<Integer> div3 = new ArrayList<>();
            List<Integer> others = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x % 6 == 0) {
                    div6.add(x);
                } else if (x % 2 == 0) {
                    div2.add(x);
                } else if (x % 3 == 0) {
                    div3.add(x);
                } else {
                    others.add(x);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int x : div6) sb.append(x).append(" ");
            for (int x : div2) sb.append(x).append(" ");
            for (int x : others) sb.append(x).append(" ");
            for (int x : div3) sb.append(x).append(" ");
            System.out.println(sb.toString().trim());
        }
        sc.close();
    }
}