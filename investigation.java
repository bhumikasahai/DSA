import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class investigation {
    static class Pair {
        long d; 
        int n;
        int min;
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
    public int solve(ArrayList<ArrayList<Pair>> adj, int V){
        long dist[] = new long[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.d,b.d));
        pq.offer(new Pair(0,1));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currn = curr.n;
            long currd = curr.d;
            if(currd>dist[currn]) continue;
            for(Pair it : )
        }

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
    }
}
