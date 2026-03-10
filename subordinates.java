import java.util.*;
import java.io.*;
public class subordinates {
    static ArrayList<Integer>[] adj;
    static int[] subordinates;
    public static void main(String[] args) {
        FastReader sc = new FastReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = sc.nextInt();
        if (n <= 0) {
            out.close();
            return;
        }
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            int superior = sc.nextInt();
            adj[superior].add(i);
        }
        subordinates = new int[n + 1];
        dfs(1);
        for (int i = 1; i <= n; i++) {
            out.print(subordinates[i] + " ");
        }
        out.println();
        out.close();
    }
    static void dfs(int u) {
        for (int v : adj[u]) {
            dfs(v);
            subordinates[u] += (subordinates[v] + 1);
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
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
}