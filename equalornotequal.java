import java.util.*;
public class equalornotequal {
    static int parent[];
    static int size[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            int n = s.length();
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='E'){
                    union(i,(i+1)%n);
                }
            }
            boolean check = true;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='N'){
                    if(find(i)==find((i+1)%n)){
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                System.out.println("YES");
            }else{
                System.out.println("NO");
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
