import java.util.*;
public class beautifulyear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int year = sc.nextInt();
        while(true){
            year++;
            if(findDigits(year)){
                System.out.println(year);
                break;
            }
        }
        sc.close();
    }
    public static boolean findDigits(int n){
        String s = Integer.toString(n);
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
