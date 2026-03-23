import java.io.*;
import java.util.*;
public class polynomialqueries {
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
    static long[] tree, lazyCount, lazyStart;
    static int[] arr;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int q = fr.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = fr.nextInt();
        tree = new long[4 * n + 1];
        lazyCount = new long[4 * n + 1];
        lazyStart = new long[4 * n + 1];
        build(1, 1, n);
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int type = fr.nextInt();
            int u = fr.nextInt();
            int v = fr.nextInt();
            if (type == 1) {
                update(1, 1, n, u, v);
            } else {
                sb.append(query(1, 1, n, u, v)).append("\n");
            }
        }
        System.out.print(sb);
    }
    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
    static void push(int node, int start, int end) {
        if (lazyCount[node] == 0 && lazyStart[node] == 0) return;
        int mid = (start + end) / 2;
        long nL = mid - start + 1;
        long nR = end - mid;
        updateNode(2 * node, start, mid, lazyCount[node], lazyStart[node]);
        updateNode(2 * node + 1, mid + 1, end, lazyCount[node], lazyStart[node] + nL * lazyCount[node]);
        lazyCount[node] = 0;
        lazyStart[node] = 0;
    }
    static void updateNode(int node, int start, int end, long count, long sVal) {
        long n = end - start + 1;
        tree[node] += n * sVal + (n * (n - 1) / 2) * count;
        lazyCount[node] += count;
        lazyStart[node] += sVal;
    }
    static void update(int node, int start, int end, int l, int r) {
        if (start > end || start > r || end < l) return;
        if (start >= l && end <= r) {
            updateNode(node, start, end, 1, start - l + 1);
            return;
        }
        push(node, start, end);
        int mid = (start + end) / 2;
        update(2 * node, start, mid, l, r);
        update(2 * node + 1, mid + 1, end, l, r);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
    static long query(int node, int start, int end, int l, int r) {
        if (start > end || start > r || end < l) return 0;
        if (start >= l && end <= r) return tree[node];
        push(node, start, end);
        int mid = (start + end) / 2;
        return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
    }
}