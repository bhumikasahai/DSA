import java.util.*;
import java.io.*;
public class buildingteams {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] color;
    public static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; 
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : adj.get(curr)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[curr];  
                    q.add(neighbor);
                }
                else if (color[neighbor] == color[curr]) {
                    return false; 
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;  
            int v = Integer.parseInt(st.nextToken()) - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(i)) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            sb.append(color[i] + 1).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}