import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class minknightmoves {
    static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static class Pair {
        int x, y, dist;
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static int bfs(int sr, int sc, int ex, int ey) {
        if (sr == ex && sc == ey) return 0;
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[8][8];
        q.add(new Pair(sr, sc, 0));
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny]) {
                    if (nx == ex && ny == ey) {
                        return curr.dist + 1;
                    }
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, curr.dist + 1));
                }
            }
        }
        return -1;
    }
    static int[] convert(String s) {
        int col = s.charAt(0) - 'a';
        int row = s.charAt(1) - '1';
        return new int[]{row, col};
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return; 
                st = new StringTokenizer(line);
            }
            String start = st.nextToken();
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return;
                st = new StringTokenizer(line);
            }
            String end = st.nextToken();
            int[] src = convert(start);
            int[] dest = convert(end);
            System.out.println(bfs(src[0], src[1], dest[0], dest[1]));
        }
    }
}