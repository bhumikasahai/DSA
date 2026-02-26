import java.util.*;
import java.io.*;
public class connectthedots {
    static int component;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            component = n;
            int[] parent = new int[n + 1];
            int[] size = new int[n + 1];
            int[][] grid = new int[11][n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                grid[d][a] = Math.max(grid[d][a], k);
            }
            for (int d = 1; d <= 10; d++) {
                for (int i = 1; i <= n; i++) {
                    if (grid[d][i] > 0) {
                        if (i + d <= n) {
                            union(i, i + d, parent, size);
                            grid[d][i + d] = Math.max(grid[d][i + d], grid[d][i] - 1);
                        }
                    }
                }
            }
            System.out.println(component);
        }
    }
    public static int find(int i, int[] parent) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i], parent);
    }
    public static void union(int u, int v, int[] parent, int[] size) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        if (rootU != rootV) {
            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            } else {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            }
            component--;
        }
    }
}