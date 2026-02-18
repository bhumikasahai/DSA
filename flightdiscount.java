import java.util.*;
import java.io.*;
public class flightdiscount {
    static class Pair {
        long d; 
        int n;
        int used; 
        Pair(long d, int n, int used) {
            this.d = d;
            this.n = n;
            this.used = used;
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
        public void addEdge(int u, int v, int w) {
            adj.get(u).add(new Pair(w, v, 0)); 
        }
    }
    public long solve(ArrayList<ArrayList<Pair>> adj, int V) {
        long dist[][] = new long[V + 1][2];
        for(int i = 0; i <= V; i++){
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }
        dist[1][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));
        pq.add(new Pair(0, 1, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currn = curr.n;
            long currd = curr.d;
            int used = curr.used;
            if (currd > dist[currn][used]) continue;
            for (Pair it : adj.get(currn)) {
                int i = it.n;
                long w = it.d;
                if (used == 0) {
                    if (dist[i][1] > currd + (w / 2)) {
                        dist[i][1] = currd + (w / 2);
                        pq.add(new Pair(dist[i][1], i, 1));
                    }
                    if(dist[i][0] > currd + w){
                        dist[i][0] = currd + w;
                        pq.add(new Pair(dist[i][0], i, 0));
                    }
                } else {
                    if (dist[i][1] > currd + w) {
                        dist[i][1] = currd + w;
                        pq.add(new Pair(dist[i][1], i, 1));
                    }
                }
            }
        }
        return dist[V][1];
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Graph g = new Graph(V);
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.addEdge(u, v, w);
        }
        flightdiscount obj = new flightdiscount();
        long ans = obj.solve(g.adj, V);
        System.out.println(ans);
    }
}