import java.io.*;
import java.util.*;
public class networkbreakdown {
    static int component;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        component = n;
        int parent[] = new int[n + 1];
        int size[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int edges[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }
        int removed[][] = new int[k][2];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            removed[i][0] = u;
            removed[i][1] = v;
            String key1 = u + "#" + v;
            String key2 = v + "#" + u;
            map.put(key1, 1);
            map.put(key2, 1);
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            String key = u + "#" + v;
            if (!map.containsKey(key)) {
                union(u, v, parent, size);
            }
        }
        int ans[] = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = component;
            int u = removed[i][0];
            int v = removed[i][1];
            union(u, v, parent, size);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static int find(int i, int parent[]) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i], parent);
    }
    public static void union(int u, int v, int parent[], int size[]) {
        int pu = find(u, parent);
        int pv = find(v, parent);
        if (pu == pv) return;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        component--;
    }
}