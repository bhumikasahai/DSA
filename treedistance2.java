import java.util.*;
public class treedistance2 {
    static List<Integer>[] tree;
    static int n;
    static long[] ans;
    static void dfs(int node, int parent, int dist, long[] sum) {
        sum[0] += dist;
        for (int child : tree[node]) {
            if (child != parent) {
                dfs(child, node, dist + 1, sum);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }
        ans = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            long[] sum = new long[1];
            dfs(i, -1, 0, sum);
            ans[i] = sum[0];
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}