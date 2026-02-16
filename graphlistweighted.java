import java.util.*;
class Pair<K, V> {
    K first;
    V second;
    Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}
public class graphlistweighted {
    static class Graph {
        int V;
        ArrayList<ArrayList<Pair<Integer, Integer>>> adj;
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }
        void addEdge(int u, int v, int w) {
            adj.get(u).add(new Pair<>(v, w));
            adj.get(v).add(new Pair<>(u, w)); 
        }
        void printGraph() {
            System.out.println("\nWeighted Adjacency List:");
            for (int i = 0; i < V; i++) {
                System.out.print(i + " -> ");
                for (Pair<Integer, Integer> edge : adj.get(i)) {
                    System.out.print("(" + edge.first + "," + edge.second + ") ");
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
        System.out.println("Enter edges and weights (u v w):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(u, v, w);
        }
        g.printGraph();
        sc.close();
    }
}