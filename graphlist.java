import java.util.*;
public class graphlist {
    static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }
        void addEdge(int u, int v) {
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
    public static void main(String[] args) {
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
        sc.close();
    }
}



