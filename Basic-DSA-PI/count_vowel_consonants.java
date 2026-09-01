import java.util.*;
public class count_vowel_consonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solve(str);
    }  
    public static void solve(String str){
        int vowel = 0;
        int consonant = 0;
        String s = str.toLowerCase();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    vowel++;
                }else{
                    consonant++;
                }
            }
        }
        System.out.println(vowel);
        System.out.println(consonant);
    }   
}
