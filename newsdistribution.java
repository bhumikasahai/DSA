import java.io.*;
import java.util.*;
public class newsdistribution {
    static int component;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        component = n;
        int parent[] = new int[n];
        int size[] = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) continue;
            int first = Integer.parseInt(st.nextToken()) - 1;
            for(int j = 1; j < k; j++){
                int member = Integer.parseInt(st.nextToken()) - 1;
                union(first, member, parent, size);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int root = find(i, parent);
            sb.append(size[root]).append(" ");
        }

        System.out.println(sb);
    }
    public static int find(int i, int parent[]){
        if(i == parent[i]){
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
    public static void union(int u, int v, int parent[], int size[]){
        int u_parent = find(u, parent);
        int v_parent = find(v, parent);
        if(u_parent == v_parent){
            return;
        }
        if(size[u_parent] < size[v_parent]){
            parent[u_parent] = v_parent;
            size[v_parent] += size[u_parent];
        }
        else{
            parent[v_parent] = u_parent;
            size[u_parent] += size[v_parent];
        }
        component--;
    }
}