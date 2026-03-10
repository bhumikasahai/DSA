import java.util.*;
public class bookexchange{
    static int parent[];
    static int size[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int p[] = new int[n+1];
            parent = new int[n+1];
            size = new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i] = i;
                size[i] = 1;
            }
            for(int i=1;i<=n;i++){
                p[i] = sc.nextInt();
                union(i,p[i]);
            }
            for(int i=1;i<=n;i++){
                int root = find(i);
                System.out.print(size[root]+" ");
            }
            System.out.println();
        }
    }
    public static int find(int i){
        if(i==parent[i]){
            return i;
        }
        return parent[i] = find(parent[i]);
    }
    public static void union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu==pv){
            return;
        }
        if(size[pu]<size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}