import java.io.*;
import java.util.*;
public class messageroute {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null; 
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
    static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) { 
                adj.add(new ArrayList<>());
            }
        }
        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    static void bfs(Graph g, int n) {
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        parent[1] = -1;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == n) break; 
            for (int v : g.adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!visited[n]) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int curr = n;
        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }
        Collections.reverse(path);
        sb.append(path.size()).append("\n");
        for (int x : path) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int V = sc.nextInt();
        int E = sc.nextInt();
        Graph g = new Graph(V);
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        bfs(g, V);
    }
}