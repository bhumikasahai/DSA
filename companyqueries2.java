import java.util.*;
public class companyqueries2 {
    static int LOG = 20;
    static int up[][];
    static int dist[];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int boss[] = new int[n-1];
        dist = new int[n+1];
        up = new int[n+1][LOG];
        up[1][0] = -1;
        for(int i=2;i<=n;i++){
            up[i][0] = sc.nextInt();
        }
        for(int j=1;j<LOG;j++){
            for(int i=1;i<=n;i++){
                if(up[i][j-1]==-1){
                    up[i][j] = -1;
                }else{
                    up[i][j] = up[up[i][j-1]][j-1];
                }
            }
        }
        while(q--
    }
    public static int lca(int a, int b){
        if(dist[a]<dist[b]){
            int temp = a;
            a = b;
            b = temp;
            int diff = dis[a]-dis[b];
            for(int j=0;j<LOG;j++){
                if(diff && 1<<j){
                    a = up[a][j];
                }
            }
            if(a==b) return a;
            for(int j = LOG;j>=0;j--){
                if(
                }
            }
        }
    }
    public int getAncestor(int node, int k){
        for(int j=0;j<LOG;j++){
            if((k & (1<<j))!=0){
                node = up[node][j];
            }
            if(node==-1) return -1;
        }
        return node;
    }
}
