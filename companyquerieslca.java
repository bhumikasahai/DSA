import java.util.*;
public class companyquerieslca {
    static int LOG = 20;
    static int up[][];
    static int dist[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int q = sc.nextInt();
        dist = new int[n + 1];
        up = new int[n + 1][LOG];
        up[1][0] = -1;
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            up[i][0] = sc.nextInt();
            tree[up[i][0]].add(i); 
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0; 
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int child : tree[curr]) {
                dist[child] = dist[curr] + 1;
                queue.add(child);
            }
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                if (up[i][j - 1] == -1) {
                    up[i][j] = -1;
                } else {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            sb.append(lca(node1, node2)).append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
    public static int lca(int a, int b) {
        if (dist[a] < dist[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int diff = dist[a] - dist[b];
        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                a = up[a][j];
            }
        }
        if (a == b) return a;
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[a][j] != up[b][j]) {
                a = up[a][j];
                b = up[b][j];
            }
        }
        return up[a][0];
    }
}