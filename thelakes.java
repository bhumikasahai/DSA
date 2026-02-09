import java.io.*;
import java.util.*;
public class thelakes {
    static int n, m;
    static int[][] grid;
    //static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int bfs(int sr, int sc) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int sum = grid[sr][sc];
        grid[sr][sc] = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (grid[nr][nc] > 0) {
                        sum += grid[nr][nc];
                        grid[nr][nc] = 0;
                        q.add(new Pair(nr, nc));
                    }
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            grid = new int[n][m];
            //visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > 0) {
                        ans = Math.max(ans, bfs(i, j));
                    }
                }
            }
            out.append(ans).append('\n');
        }
        System.out.print(out.toString());
    }
}
