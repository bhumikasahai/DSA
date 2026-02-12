import java.io.*;
import java.util.*;
public class roundtrip {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static int[] parent;
    static int start = -1, end = -1;
    public static boolean detectCycle(int src, int par) {
        visited[src] = true;
        for (int i : adj.get(src)) {
            if (i == par) continue;
            if (!visited[i]) {
                parent[i] = src;
                if (detectCycle(i, src)) return true;
            } else {
                start = i;
                end = src;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        visited = new boolean[V + 1];
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, -1)) break;
            }
        }
        if (start == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(start);
            for (int i = end; i != start; i = parent[i]) {
                result.add(i);
            }
            result.add(start);
            Collections.reverse(result);
            System.out.println(result.size());
            for (int node : result) {
                System.out.print(node + " ");
            }
        }
    }
}
