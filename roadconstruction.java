import java.util.*;
public class roadconstruction {
    static int component;
    static class Edge{
        int w;
        int u;
        int v;
        Edge(int w, int u, int v){
            this.w = w;
            this.u = u;
            this.v = v;
        }
    }
    public static int find(int i, int parent[]){
        if(i==parent[i]){
            return i;
        }
        return parent[i] = find(parent[i],parent);
    }
    public static boolean union(int u, int v, int parent[], int size[]){
        int u_parent = find(u,parent);
        int v_parent = find(v,parent);
        if(u_parent == v_parent){
            return false;
        }
        if(size[u_parent]<size[v_parent]){
            parent[u_parent] = v_parent;
            size[v_parent] += size[u_parent];
        }else{
            parent[v_parent] = u_parent;
            size[u_parent] += size[v_parent];
        }
        component--;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            int u = sc.nextInt(); 
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(w, u, v));
        }
        edges.sort(Comparator.comparingInt(e -> e.w));
        int parent[] = new int[V+1];
        int size[] = new int[V+1];
        for(int i=1;i<=V;i++){
            parent[i] = i;
            size[i] = 1;
        }
        component = V;
        long totalcost = 0;
        for(Edge e : edges) {
            if(union(e.u, e.v, parent, size)) {
                totalcost += e.w;
            }
        }
        if(component == 1) {
            System.out.println(totalcost);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
