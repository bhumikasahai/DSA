import java.util.*;
import java.io.*; 
public class roadconstruction {
    static int component;
    static int max_size = 1; 
    public static int find(int i, int parent[]) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
    public static void union(int u, int v, int parent[], int size[]) {
        int u_parent = find(u, parent);
        int v_parent = find(v, parent);
        if (u_parent != v_parent) {
            if (size[u_parent] < size[v_parent]) {
                parent[u_parent] = v_parent;
                size[v_parent] += size[u_parent];
                max_size = Math.max(max_size, size[v_parent]);
            } else {
                parent[v_parent] = u_parent;
                size[u_parent] += size[v_parent];
                max_size = Math.max(max_size, size[u_parent]);
            }
            component--; 
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int parent[] = new int[V + 1];
        int size[] = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        component = V;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v, parent, size);
            sb.append(component).append(" ").append(max_size).append("\n");
        }
        System.out.print(sb);
    }
}