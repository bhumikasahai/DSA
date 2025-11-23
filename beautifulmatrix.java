import java.util.*;
public class beautifulmatrix{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int r = 0, c = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (!sc.hasNextInt()) {     
                    sc.next();              
                    j--;                    
                    continue;
                }
                int x = sc.nextInt();
                if (x == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        int moves = Math.abs(r - 3) + Math.abs(c - 3);
        System.out.println(moves);
        sc.close();
    }
}
