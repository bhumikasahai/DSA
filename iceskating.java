import java.util.*;
public class iceskating {
    static boolean[] visited;
    static ArrayList<List<Integer>> points;
    static void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < points.size(); j++) {
            if (!visited[j]) {
                if (points.get(i).get(0).equals(points.get(j).get(0)) ||
                    points.get(i).get(1).equals(points.get(j).get(1))) {
                    dfs(j);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            List<Integer> pair = new ArrayList<>();
            pair.add(u);   
            pair.add(v);   
            points.add(pair);
        }
        visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i);
            }
        }
        System.out.println(components - 1);
        sc.close();
    }
}
