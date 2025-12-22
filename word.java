import java.util.*;
public class word{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int upper = 0;
        int lower = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                upper++;
            }else if(Character.isLowerCase(ch)){
                lower++;
            }
        }
        if(upper>lower){
            s = s.toUpperCase();
        }else if(lower>upper){
            s = s.toLowerCase();
        }else{
            s = s.toLowerCase();
        }
        System.out.println(s);
        sc.close();
    }
}