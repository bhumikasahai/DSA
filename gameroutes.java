import java.io.*;
import java.util.*;
public class gameroutes {
     static final long MOD = 1000000007;
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
        long dp[] = new long[V];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int u : ans) {
            if (dp[u] == 0) continue;
            for (int v : adj.get(u)) {
                dp[v] = (dp[v]+dp[u])%MOD;
            }
        }
        System.out.println(dp[V-1]);
    }
}
