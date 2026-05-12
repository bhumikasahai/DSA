import java.util.*;
public class maxwhitesubtree {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] val;
    static int[] dp;
    static int[] ans;
    static void dfs1(int node, int parent) {
        dp[node] = val[node];
        for (int child : adj.get(node)) {
            if (child == parent) continue;
            dfs1(child, node);
            dp[node] += Math.max(0, dp[child]);
        }
    }
    static void dfs2(int node, int parent) {
        for (int child : adj.get(node)) {
            if (child == parent) continue;
            ans[child] = dp[child] + Math.max(0, ans[node] - Math.max(0, dp[child]));
            dfs2(child, node);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        val = new int[n + 1];
        dp = new int[n + 1];
        ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int color = sc.nextInt();
            val[i] = (color == 1) ? 1 : -1;
        }
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs1(1, -1);
        ans[1] = dp[1];
        dfs2(1, -1);
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}