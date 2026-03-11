import java.io.*;
import java.util.*;

public class treedistance {
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {

        n = nextInt();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = nextInt();
            int v = nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist1 = bfs(1, adj);
        int maxA = findMaxIndex(dist1);

        int[] endA = bfs(maxA, adj);
        int maxB = findMaxIndex(endA);

        int[] endB = bfs(maxB, adj);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(endA[i], endB[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    public static int[] bfs(int src, ArrayList<ArrayList<Integer>> adj) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        distances[src] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int neighbor : adj.get(u)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[u] + 1;
                    q.add(neighbor);
                }
            }
        }

        return distances;
    }

    public static int findMaxIndex(int[] dist) {
        int maxIdx = 1;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > dist[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static int nextInt() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}