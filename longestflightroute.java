import java.io.*;
import java.util.*;
public class longestflightroute {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (int next : adj.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        if (ans.size() != V) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        int dp[] = new int[V];
        int parent[] = new int[V];
        Arrays.fill(dp, Integer.MIN_VALUE);
        Arrays.fill(parent, -1);
        dp[0] = 1; 
        for (int u : ans) {
            if (dp[u] == Integer.MIN_VALUE) continue;
            for (int v : adj.get(u)) {
                if (dp[u] + 1 > dp[v]) {
                    dp[v] = dp[u] + 1;
                    parent[v] = u;
                }
            }
        }
        if (dp[V - 1] == Integer.MIN_VALUE) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int curr = V - 1;
        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        sb.append(path.size()).append("\n");
        for (int node : path) {
            sb.append(node + 1).append(" ");
        }
        System.out.println(sb);
    }
}
