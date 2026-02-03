import java.util.*;
class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=1;i<=n;i++){
            if(adj.get(i).size()==edges.length){
                return i;
            }
        }
        return -1;
    }
}