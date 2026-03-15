import java.util.*;
public class lastyeardivison{
    static String target = "2020";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String s = sc.next();
            if(n<4){
                System.out.println("NO");
                continue;
            }
            if(solve(s,0,n-1,0,3)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
    public static boolean solve(String s, int sleft, int sright, int tleft, int tright){
        if(tleft>tright){
            return true;
        }
        boolean possible = false;
        if(s.charAt(sleft)==target.charAt(tleft)){
            possible = possible || solve(s,sleft+1,sright,tleft+1,tright);
        }
        if(!possible && s.charAt(sright)==target.charAt(tright)){
            possible = possible || solve(s,sleft,sright-1,tleft,tright-1);
        }
        return possible;
    }
}