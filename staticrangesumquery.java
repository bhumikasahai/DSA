import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class staticrangesumquery {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long arr[] = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long prefix[] = new long[n + 1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        while(q-- > 0){
            st = new StringTokenizer(br.readLine());
            int ql = Integer.parseInt(st.nextToken()) - 1; 
            int qr = Integer.parseInt(st.nextToken()) - 1;
            if()
            long ans = prefix[r] - prefix[l - 1];
            System.out.println(ans);
        }
    }
}