import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class investigation {
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
        public void addEdge(int u, int v, int w) {
            adj.get(u).add(new Pair(w, v)); 
        }
    }
    public void solve(ArrayList<ArrayList<Pair>> adj, int V){
        long MOD = 1_000_000_007;
        long dist[] = new long[V+1];
        long ways[] = new long[V+1];
        int minedge[] = new int[V+1];
        int maxedge[] = new int[V+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(minedge, Integer.MAX_VALUE);
        dist[1] = 0;
        ways[1] = 1;
        minedge[1] = 0;
        maxedge[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.d,b.d));
        pq.offer(new Pair(0,1));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currn = curr.n;
            long currd = curr.d;
            if(currd > dist[currn]) continue;
            for(Pair it : adj.get(currn)){
                int i = it.n;
                long w = it.d;
                if(dist[currn] + w < dist[i]){
                    dist[i] = currd+w;
                    ways[i] = ways[currn];
                    minedge[i] = minedge[currn]+1;
                    maxedge[i] = maxedge[currn]+1;
                    pq.offer(new Pair(dist[i],i));
                }else if(dist[currn]+w==dist[i]){
                    ways[i] = (ways[i]+ways[currn])%MOD;
                    minedge[i] = Math.min(minedge[i],minedge[currn]+1);
                    maxedge[i] = Math.max(maxedge[i],maxedge[currn]+1);
                }
            }
        }
        System.out.println(dist[V] + " " + ways[V] + " " + minedge[V] + " " + maxedge[V]);
    }
    public static void main(String args[]) throws IOException{
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
        investigation solver = new investigation();
        solver.solve(g.adj, V);
    }
}
