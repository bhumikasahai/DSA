import java.util.*;
public class longestpath {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[V+1];
        int dp[] = new int[V+1];
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<=V;i++){
            if(indegree[i]==0){
                q.add(i);
                dp[i] = 0;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int it : adj.get(curr)){
                indegree[it]--;
                dp[it] = Math.max(dp[it],dp[curr]+1);
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= V; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
