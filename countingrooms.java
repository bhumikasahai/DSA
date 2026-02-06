import java.io.*;
import java.util.*;
public class countingrooms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        System.out.println(count);
    }
    public static void dfs(int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '#') {
            return;
        }
        grid[r][c] = '#'; 
        dfs(r - 1, c, grid); 
        dfs(r + 1, c, grid); 
        dfs(r, c - 1, grid); 
        dfs(r, c + 1, grid); 
    }
}
