import java.util.*;
public class computergame {
    static int row = 2;
    static int col;
    static int mat[][];
    static boolean visited[][];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            col = sc.nextInt();
            mat = new int[2][col];
            visited = new boolean[2][col];
            for (int i = 0; i < 2; i++) {
                String s = sc.next();
                for (int j = 0; j < col; j++) {
                    mat[i][j] = s.charAt(j) - '0';
                }
            }
            dfs(0, 0);
            if (visited[1][col - 1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static void dfs(int i, int j) {
        if (i < 0 || i >= 2 || j < 0 || j >= col || mat[i][j] == 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
        dfs(i - 1, j - 1);
        dfs(i + 1, j - 1);
        dfs(i + 1, j + 1);
        dfs(i - 1, j + 1);
    }
}