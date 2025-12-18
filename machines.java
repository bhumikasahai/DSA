import java.io.*;
import java.util.*;
public class machines {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        long t = fs.nextLong();
        long[] machines = new long[n];
        long minTime = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            machines[i] = fs.nextLong();
            minTime = Math.min(minTime, machines[i]);
        }
        long low = 0;
        long high = minTime * t;  
        long ans = high;
        while (low <= high) {
            long mid = (low + high) / 2;

            if (canProduce(mid, machines, t)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
    static boolean canProduce(long time, long[] machines, long target) {
        long products = 0;
        for (long m : machines) {
            products += time / m;
            if (products >= target) return true; // prevent overflow
        }
        return false;
    }
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;
        FastScanner(InputStream in) {
            this.in = in;
        }
        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            long val = 0;
            int c;
            while ((c = read()) <= ' ') ;
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }
        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
