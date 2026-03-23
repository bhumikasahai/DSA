import java.io.*;
import java.util.*;
public class incrsubsequencesegment {
    static long seg[];
    static long MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n];
        long darr[] = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            darr[i] = arr[i];
        }
        Arrays.sort(darr);
        long unique[] = new long[n];
        unique[0] = darr[0];
        int j = 1;

        for (int i = 1; i < n; i++) {
            if (darr[i] != unique[j - 1]) {
                unique[j++] = darr[i];
            }
        }
        int size = j;
        seg = new long[4 * size];
        for (int i = 0; i < n; i++) {
            int id = binarySearch(arr[i], unique, size);
            long cnt = (id > 0) ? query(0, 0, size - 1, 0, id - 1) : 0;
            cnt = (cnt + 1) % MOD;
            update(0, 0, size - 1, id, cnt);
        }
        System.out.println(seg[0]);
    }
    public static long query(int idx, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) return 0;
        if (l >= ql && r <= qr) return seg[idx];
        int m = (l + r) / 2;
        long left = query(2 * idx + 1, l, m, ql, qr);
        long right = query(2 * idx + 2, m + 1, r, ql, qr);
        return (left + right) % MOD;
    }
    public static void update(int idx, int l, int r, int i, long val) {
        if (l == r) {
            seg[idx] = (seg[idx] + val) % MOD;
            return;
        }
        int m = (l + r) / 2;
        if (i <= m)
            update(2 * idx + 1, l, m, i, val);
        else
            update(2 * idx + 2, m + 1, r, i, val);

        seg[idx] = (seg[2 * idx + 1] + seg[2 * idx + 2]) % MOD;
    }
    public static int binarySearch(long val, long arr[], int size) {
        int l = 0, r = size - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == val) return mid;
            else if (arr[mid] < val) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}