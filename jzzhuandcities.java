import java.io.*;
import java.util.*;
public class jzzhuandcities {
    static class Graph {
        int V;
        ArrayList<ArrayList<Pair>> adj;
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }
    }
    static class Pair {
        int d;
        int n;
        int t;
        Pair(int d, int n, int t) {
            this.d = d;   
            this.n = n;  
            this.t = t;   
        }
    }
    public static int solve(ArrayList<ArrayList<Pair>> adj, int V, int k) {
    long dist[] = new long[V + 1];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[1] = 0;

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));
    pq.offer(new Pair(0, 1, 0));

    boolean usedTrain[] = new boolean[V + 1];

    while (!pq.isEmpty()) {
        Pair curr = pq.poll();
        long currd = curr.d;
        int currn = curr.n;
        int trainUsed = curr.t;

        if (currd > dist[currn]) continue;

        if (trainUsed == 1) usedTrain[currn] = true;

        for (Pair it : adj.get(currn)) {
            int next = it.n;
            long newDist = currd + it.d;

            if (newDist < dist[next]) {
                dist[next] = newDist;
                pq.offer(new Pair((int)newDist, next, it.t));
            }
        }
    }

    int countUsed = 0;
    for (int i = 2; i <= V; i++) {
        if (usedTrain[i]) countUsed++;
    }

    return k - countUsed;
}

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Pair(w, v, 0));
            adj.get(v).add(new Pair(w, u, 0));
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj.get(1).add(new Pair(y, s, 1));
        }
        System.out.println(solve(adj, n, k));
    }
}
