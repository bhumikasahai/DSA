import java.util.*;
public class graphmat {
    static class Graph {
        int V;              
        int[][] adjMatrix;  
        Graph(int V) {
            this.V = V;
            adjMatrix = new int[V][V];
        }
        void addEdge(int u, int v) {
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }
        void printMatrix() {
            System.out.println("Adjacency Matrix:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        Graph g = new Graph(V);
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        g.printMatrix();
        sc.close();
    }
}
