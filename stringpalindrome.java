import java.util.*;
public class stringpalindrome {
    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        int n = s.length();
        boolean ok = true;
        ok &= isPalindrome(s, 0, n - 1);
        ok &= isPalindrome(s, 0, (n - 1) / 2 - 1);
        ok &= isPalindrome(s, (n + 1) / 2, n - 1);
        System.out.println(ok ? "Yes" : "No");
    }
}
