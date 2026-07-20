import java.io.*;
import java.util.*;
public class task {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks[i][0] = Integer.parseInt(st.nextToken());
            tasks[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));
        long ct = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ct += tasks[i][0];
            ans += (long) tasks[i][1] - ct;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(ans);
        System.out.print(sb);
    }
}