import java.util.*;
public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }

    //BRUTE
    //public static boolean solve(int n){
    //    String s = String.valueOf(n);
    //    int left = 0;
    //    int right = s.length()-1;
    //    while(left<=right){
    //        if(s.charAt(0)!=s.charAt(s.length()-1)){
    //            return false;
    //        }
    //        left++;
    //        right--;
    //    }
    //    return true;
    //}

    //OPTIMAL
    public static boolean solve(int n){
        if(n<0){
            return false;
        }
        int reversed = 0;
        int original = n;
        while(n>0){
            int digit = n%10;
            reversed = reversed*10 + digit;
            n = n/10;
        }
        return original==reversed;
    }
}
