import java.util.*;
public class dsuA{
    static int parent[];
    static int size[];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i=0;i<m;i++){
            String type = sc.next();
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            if(type.equals("union")){
                union(u,v);
            }else if(type.equals("get")){
                if(find(u)==find(v)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
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