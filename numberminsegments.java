import java.io.*;
import java.util.*;
public class numberminsegments {
    static class Pair {
        long m;
        int c;
        Pair(long m, int c) {
            this.m = m;
            this.c = c;
        }
    }
    static Pair[] seg;
    static long[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        arr = new long[n];
        seg = new Pair[4 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        segbuild(0, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int k = Integer.parseInt(st.nextToken());
                long u = Long.parseLong(st.nextToken());
                update(0, 0, n - 1, k, u);
            } else {
                int l = Integer.parseInt(st.nextToken()) ;
                int r = Integer.parseInt(st.nextToken());
                Pair ans = minquery(0, 0, n - 1, l, r-1);
                sb.append(ans.m).append(" ").append(ans.c).append("\n");
            }
        }
        System.out.print(sb);
    }
    static void segbuild(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = new Pair(arr[l], 1);
            return;
        }
        int mid = (l + r) / 2;
        segbuild(2 * idx + 1, l, mid);
        segbuild(2 * idx + 2, mid + 1, r);
        seg[idx] = combine(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    static Pair combine(Pair a, Pair b) {
        if (a.m < b.m) return  a;
        if (b.m < a.m) return b;
        return new Pair(a.m, a.c + b.c);
    }
    static void update(int idx, int l, int r, int i, long val) {
        if (l == r) {
            seg[idx] = new Pair(val, 1);
            return;
        }
        int mid = (l + r) / 2;
        if (i <= mid) {
            update(2 * idx + 1, l, mid, i, val);
        } else {
            update(2 * idx + 2, mid + 1, r, i, val);
        }
        seg[idx] = combine(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    static Pair minquery(int idx, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) {
            return new Pair(Long.MAX_VALUE, 0);
        }
        if (ql <= l && r <= qr) {
            return seg[idx];
        }
        int mid = (l + r) / 2;
        Pair left = minquery(2 * idx + 1, l, mid, ql, qr);
        Pair right = minquery(2 * idx + 2, mid + 1, r, ql, qr);
        return combine(left, right);
    }
}