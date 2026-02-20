import java.io.*;
import java.util.*;
public class jzzhuandcities {
    static class Pair {
        long d; 
        int n;
        int t;

        Pair(long d, int n, int t) {
            this.d = d;
            this.n = n;
            this.t = t;
        }
    }

    public static int solve(ArrayList<ArrayList<Pair>> adj, int V, int k) {
        long[] dist = new long[V + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.d != b.d) return Long.compare(a.d, b.d);
            return Integer.compare(a.t, b.t);
        });

        pq.offer(new Pair(0, 1, 0));
        int[] usedTrain = new int[V + 1];

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long currd = curr.d;
            int currn = curr.n;
            if (currd > dist[currn]) continue;
            for (Pair it : adj.get(currn)) {
                int next = it.n;
                long newDist = currd + it.d;
                int edgeType = it.t;
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    usedTrain[next] = edgeType; 
                    pq.offer(new Pair(newDist, next, edgeType));
                } else if (newDist == dist[next] && edgeType == 0) {
                    usedTrain[next] = 0;
                }
            }
        }
        int countUsed = 0;
        for (int i = 2; i <= V; i++) {
            if (usedTrain[i] == 1) countUsed++;
        }
        return k - countUsed;
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
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