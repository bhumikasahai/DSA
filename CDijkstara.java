import java.io.*;
import java.util.*;
public class CDijkstara {
    static class Pair {
        long d;
        int n;
        Pair(long d, int n) {
            this.d = d;
            this.n = n;
        }
    }
    static class Graph {
        int V;
        ArrayList<ArrayList<Pair>> adj;
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) {  
                adj.add(new ArrayList<>());
            }
        }
        public void adEdge(int u, int v, int w) {
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }
    }
    public static void solve(ArrayList<ArrayList<Pair>> adj, int V) {
        long dist[] = new long[V + 1];
        int parent[] = new int[V + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));
        dist[1] = 0;
        pq.offer(new Pair(0, 1));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long currd = curr.d;
            int currn = curr.n;
            if (currd > dist[currn]) continue;
            for (Pair it : adj.get(currn)) {
                int i = it.n;
                long w = it.d;
                if (currd + w < dist[i]) {
                    dist[i] = currd + w;
                    parent[i] = currn;
                    pq.offer(new Pair(dist[i], i));
                }
            }
        }
        if (dist[V] == Long.MAX_VALUE) {
            System.out.println("-1");
        } else {
            List<Integer> path = new ArrayList<>();
            for (int v = V; v != -1; v = parent[v]) {
                path.add(v);
            }
            Collections.reverse(path);
            StringBuilder sb = new StringBuilder();
            for (int node : path) {
                sb.append(node).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Graph g = new Graph(V);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.adEdge(u, v, w);
        }
        solve(g.adj, V);
    }
}
