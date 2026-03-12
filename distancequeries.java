import java.util.*;
public class distancequeries{
    static int LOG;
    static int up[][];
    static int dist[];
    static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LOG= 20;
        int n = sc.nextInt();
        int q = sc.nextInt();
        adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        up = new int[n+1][LOG];
        for(int i=0;i<=n;i++){
            Arrays.fill(up[i], -1);
        }
        dist = new int[n+1];
        Arrays.fill(dist,-1);
        dist[1] = 0;
        dfs(1,-1);
        for(int j=1;j<LOG;j++){
            for(int i=1;i<=n;i++){
                if(up[i][j-1]==-1){
                    up[i][j] = -1;
                }else{
                    up[i][j] = up[up[i][j-1]][j-1];
                }
            }
        }
        while(q-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = lca(a,b);
            int ans = dist[a]+dist[b]-2*dist[l];
            System.out.println(ans);
        }

    }
    public static void dfs(int node, int parent){
        up[node][0] = parent;
        for(int i : adj.get(node)){
            if(i != parent){
                dist[i] = dist[node] + 1;
                dfs(i,node);
            }    
        }
    }
    public static int getAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                node = up[node][j];
                if (node == -1) return -1;
            }
        }
        return node;
    }
    public static int lca(int a, int b){
        if(dist[a]<dist[b]){
            int temp = a;
            a = b;
            b = temp;    
        }
        int diff = dist[a]-dist[b];
        a = getAncestor(a,diff);
        if(a==b) return a;
        for(int j = LOG-1;j>=0;j--){
            if(up[a][j] != up[b][j]){
                a = up[a][j];
                b = up[b][j];
            }
        }
        return up[a][0];
    }
}