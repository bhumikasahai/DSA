import java.util.*;
public class coloringatree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=2;i<=n;i++){
            int p = sc.nextInt();
            adj.get(p).add(i);
        }
        int color[] = new int[n+1];
        for(int i=1;i<=n;i++){
            color[i] = sc.nextInt();
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0});
        int ans = 0;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int node = curr[0];
            int parentColor = curr[1];
            if(color[node] != parentColor){
                ans++;
            }
            for(int child : adj.get(node)){
                q.offer(new int[]{child,color[node]});
            }
        }
        System.out.println(ans);
    }
}