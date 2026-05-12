import java.util.*;
public class longp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int indegree[] = new int[n+1];
        int dp[] = new int[n+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=m;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
                dp[i] = 0;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int it : adj.get(curr)){
                indegree[it]--;
                dp[it] = Math.max(dp[it],dp[curr]+1);  //for path do max of current value and previous path +1 
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
