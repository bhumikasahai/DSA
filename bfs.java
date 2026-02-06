import java.util.*;
public class bfs{
    static class Graph{
        int V;
        ArrayList<ArrayList<Integer>> adj;
        Graph(int V){
            this.V = V;
            adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
        }
        public void addEdge(int u, int v){
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        void printGraph() {
            System.out.println("Adjacency List:");
            for (int i = 0; i < V; i++) {
                System.out.print(i + " -> ");
                for (int node : adj.get(i)) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
        }
    }
    public void bfstraversal(ArrayList<ArrayList<Integer>> adj, boolean visited[], int source) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        int level = 0; 
        while (!q.isEmpty()) {
            int nodesAtCurrentLevel = q.size();
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                int u = q.poll();
                System.out.println(u + " - level " + level);
                for (int neighbor : adj.get(u)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
            level++;
        }
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
        bfs obj = new bfs();
        boolean visited[] = new boolean[V]; 
        System.out.print("Enter starting node for BFS: ");
        int source = sc.nextInt();
        System.out.println("BFS Traversal starting from " + source + ":");
        obj.bfstraversal(g.adj, visited, source);
        sc.close();
    }
}