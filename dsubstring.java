import java.io.*;
import java.util.*;
public class dsubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int[] nodeChars = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nodeChars[i + 1] = s.charAt(i) - 'a';
        }
        List<Integer>[] adj = new ArrayList[n + 1];
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            inDegree[v]++;
        }
        int[][] dp = new int[n + 1][26];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                dp[i][nodeChars[i]] = 1;
            }
        }
        int processedNodes = 0;
        int maxVal = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            processedNodes++;
            for (int v : adj[u]) {
                for (int c = 0; c < 26; c++) {
                    int addedValue = (nodeChars[v] == c) ? 1 : 0;
                    dp[v][c] = Math.max(dp[v][c], dp[u][c] + addedValue);
                }
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        if (processedNodes < n) {
            System.out.println("-1");
        } else {
            for (int i = 1; i <= n; i++) {
                for (int c = 0; c < 26; c++) {
                    maxVal = Math.max(maxVal, dp[i][c]);
                }
            }
            System.out.println(maxVal);
        }
    }
}