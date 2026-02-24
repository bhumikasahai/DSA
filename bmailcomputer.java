import java.util.*;
public class bmailcomputer {
    static int component;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        component = n;
        int parent[] = new int[n];
        int size[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
    }
    public static int find(int i, int parent[]){
        if(i==parent[i]){
            return i;
        }
        return parent[i] = find(parent[i],parent);
    }
    public static void union(int u, int v, int parent[], int size[]){
        int u_parent = find(u,parent);
        int v_parent = find(v,parent);
        if(u_parent == v_parent){
            return;
        }
        if(size[u_parent]<size[v_parent]){
            parent[u_parent] = v_parent;
            size[v_parent] += size[u_parent];
        }
        else{
            parent[v_parent] = u_parent;
            size[u_parent] += size[v_parent];
        }
        component--;
    }
}
