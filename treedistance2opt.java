import java.util.*;
public class treedistance2opt {
    static List<Integer>[] tree;
    static int n;
    static int[] subtree;
    static long[] ans;
    static void dfs1(int node, int parent, int depth) {
        subtree[node] = 1;
        ans[1] += depth;
        for (int child : tree[node]) {
            if (child != parent) {
                dfs1(child, node, depth + 1);
                subtree[node] += subtree[child];
            }
        }
    }
    static void dfs2(int node, int parent) {
        for (int child : tree[node]) {
            if (child != parent) {
                ans[child] = ans[node] + n - 2L * subtree[child];
                dfs2(child, node);
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
        subtree = new int[n + 1];
        ans = new long[n + 1];
        dfs1(1, -1, 0);   
        dfs2(1, -1);      
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}