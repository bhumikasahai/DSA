import java.util.*;
import java.io.*;

public class buildingroads {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;
        for (int next : adj[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] temp = (ArrayList<Integer>[]) new ArrayList[n + 1];
        adj = temp;

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        ArrayList<Integer> components = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                components.add(i);
                dfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(components.size() - 1).append("\n");

        for (int i = 1; i < components.size(); i++) {
            sb.append(components.get(i - 1))
              .append(" ")
              .append(components.get(i))
              .append("\n");
        }

        System.out.print(sb.toString());
    }
}
