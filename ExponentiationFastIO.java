import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class ExponentiationFastIO {
    private static final long MOD = 1_000_000_007L; 
    public static long power(long base, long exponent) {
        long res = 1;
        base %= MOD; 
        while (exponent > 0) {
            if ((exponent & 1) == 1) { 
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent >>= 1; 
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()); 
            long b = Long.parseLong(st.nextToken()); 
            long result = power(a, b);
            sb.append(result).append('\n');
        }
        System.out.print(sb.toString());
        br.close();
    }
}