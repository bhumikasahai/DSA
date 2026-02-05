import java.util.*;
public class dfsconnect {
    static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<>());
            }
        }
        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        public void printGraph() {
            for (int i = 1; i <= V; i++) {
                System.out.print(i + " -> ");
                for (int node : adj.get(i)) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
        }
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], int source) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int i : adj.get(source)) {
            if (!visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }   
    public int components(ArrayList<ArrayList<Integer>> adj, boolean visited[], int V) {
        int count = 0;
        for (int i = 1; i <= V; i++) {  
            if (!visited[i]) {
                count++;
                dfs(adj, visited, i);
                System.out.println();
            }
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        Graph g = new Graph(V);
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        g.printGraph();
        dfsconnect obj = new dfsconnect();          
        boolean visited[] = new boolean[V+1];
        int ans = obj.components(g.adj, visited, V);  
        System.out.println("Connected Components = " + ans);
        sc.close();
    }
}
