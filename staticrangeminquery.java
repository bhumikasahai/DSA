import java.io.*;
import java.util.*;
public class staticrangeminquery {
    static long seg[];
    static long arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        arr = new long[n];
        seg = new long[4 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        segbuild(0, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int ql = Integer.parseInt(st.nextToken()) - 1; 
            int qr = Integer.parseInt(st.nextToken()) - 1;
            long ans = minquery(0, 0, n - 1, ql, qr);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    public static void segbuild(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int m = l + (r - l) / 2;
        segbuild(2*idx+1,l,m);
        segbuild(2*idx+2,m+1,r);
        seg[idx] = Math.min(seg[2*idx+1], seg[2*idx+2]);
    }
    public static long minquery(int idx, int l, int r, int ql, int qr) {
        if (r<ql || l>qr) {
            return Long.MAX_VALUE;
        }
        if (l>=ql && r<=qr) {
            return seg[idx];
        }
        int m = l+(r-l) / 2;
        long left = minquery(2*idx+1,l,m,ql,qr);
        long right = minquery(2*idx+2,m+1,r,ql,qr);
        return Math.min(left, right);
    }
}