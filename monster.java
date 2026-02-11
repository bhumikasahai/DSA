import java.io.*;
import java.util.*;
public class monster {
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] dirChar = {'U', 'D', 'L', 'R'};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        char[][] parent = new char[n][m]; 
        boolean[][] visited = new boolean[n][m];
        Pair start = null;
        Pair end = null;
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'A') {
                    start= new Pair(i, j);
                }
                if (grid[i][j] == 'B') {
                    end = new Pair(i, j);
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c] = true;
        boolean found = false;
        while (!q.isEmpty()) {
            Pair curr = q.poll(); 
            if (curr.r == end.r && curr.c == end.c) {
                found = true;
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nr = curr.r + dr[k];
                int nc = curr.c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m 
                    && grid[nr][nc] != '#' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    parent[nr][nc] = dirChar[k]; 
                    q.add(new Pair(nr, nc)); 
                }
            }
        }
        if (found) {
            System.out.println("YES");
            StringBuilder path = new StringBuilder();
            Pair curr = end; 
            while (curr.r != start.r || curr.c != start.c) {
                char move = parent[curr.r][curr.c];
                path.append(move);
                if (move == 'U') curr.r++;       
                else if (move == 'D') curr.r--;  
                else if (move == 'L') curr.c++;  
                else if (move == 'R') curr.c--; 
            }
            System.out.println(path.length());
            System.out.println(path.reverse().toString());
        } else {
            System.out.println("NO");
        }
    }
}