import java.util.*;

public class luckynum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();   // read as String (safe for 10^18)
        int count = 0;

        // Count lucky digits
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '4' || ch == '7') {
                count++;
            }
        }

        // Check if count itself is lucky
        if (isLucky(count)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }

    static boolean isLucky(int num) {
        if (num == 0) return false;

        while (num > 0) {
            int d = num % 10;
            if (d != 4 && d != 7) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
