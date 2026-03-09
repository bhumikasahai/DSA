import java.util.*;
public class gregorpawn {
    static int n;
    static char[] enemy;
    static char[] gregor;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            enemy = sc.next().toCharArray();
            gregor = sc.next().toCharArray();
            
            int totalPawnsReached = 0;
            for (int j = 0; j < n; j++) {
                if (gregor[j] == '1') {
                    if (canMovePawn(j)) {
                        totalPawnsReached++;
                    }
                }
            }
            System.out.println(totalPawnsReached);
        }
    }
    public static boolean canMovePawn(int j) {
        if (j > 0 && enemy[j - 1] == '1') {
            enemy[j - 1] = '2';
            return true;
        }
        if (enemy[j] == '0') {
            enemy[j] = '2'; 
            return true;
        }
        if (j < n - 1 && enemy[j + 1] == '1') {
            enemy[j + 1] = '2'; 
            return true;
        }
        return false; 
    }
}