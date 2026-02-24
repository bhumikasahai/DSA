import java.io.*;
import java.util.*;
public class learninglanguages {
    static int component;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int parent[] = new int[n];
        int size[] = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        component = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean anyoneKnows = false;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k > 0) anyoneKnows = true;
            int firstLanguageHolder = -1;
            for(int j = 0; j < k; j++){
                int lang = Integer.parseInt(st.nextToken());
                if(map.containsKey(lang)){
                    union(i, map.get(lang), parent, size);
                } else {
                    map.put(lang, i);
                }
            }
        }
        if(!anyoneKnows){
            System.out.println(n);
        } else {
            System.out.println(component - 1);
        }
    }
    public static int find(int i, int parent[]){
        if(i == parent[i]){
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
    public static void union(int u, int v, int parent[], int size[]){
        int u_parent = find(u, parent);
        int v_parent = find(v, parent);
        if(u_parent == v_parent){
            return;
        }
        if(size[u_parent] < size[v_parent]){
            parent[u_parent] = v_parent;
            size[v_parent] += size[u_parent];
        } else {
            parent[v_parent] = u_parent;
            size[u_parent] += size[v_parent];
        }
        component--;
    }
}