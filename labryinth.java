import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class labryinth {
    public static void main (String args[]) throws IOException{
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
                    dfs(grid,i,j);
                }
            }
        }
        System.out.println(count);
    }
    public static void dfs(char grid[][], int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '#'){
            return;
        }    
        grid[i][j] = '#';
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
    }
}
