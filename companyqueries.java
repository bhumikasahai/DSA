import java.util.*;
public class companyqueries {
    static int LOG = 20;
    static int[][] up;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int q = sc.nextInt();
        up = new int[n + 1][LOG];
        up[1][0] = -1;
        for (int i = 2; i <= n; i++) {
            up[i][0] = sc.nextInt();
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                if (up[i][j - 1] == -1) {
                    up[i][j] = -1;
                } else {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(up));
        while (q-- > 0) {
            int node = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(getAncestor(node, k));
        }
        sc.close();
    }
    static int getAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                node = up[node][j];
                if (node == -1) return -1;
            }
        }
        return node;
    }
}