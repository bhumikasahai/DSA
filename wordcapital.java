import java.util.*;
public class wordcapital{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char first = s.charAt(0);
        if (Character.isLowerCase(first)) {
            s = Character.toUpperCase(first) + s.substring(1);
        }
        System.out.println(s);
        sc.close();
    }
}