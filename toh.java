import java.io.BufferedReader;
import java.io.InputStreamReader;
class toh{
    static StringBuilder sb = new StringBuilder();
    public static void hanoi(int n,int s,int h,int d){
        if(n==0) return;
        hanoi(n-1,s,d,h);
        sb.append(s).append(" ").append(d).append("\n");
        hanoi(n-1,h,s,d);
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long totalMoves = (1L << n) - 1;  
        System.out.println(totalMoves);
        hanoi(n, 1, 2, 3);
        System.out.print(sb.toString());
    }
}