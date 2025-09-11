import java.util.*;
class Solution {
    public String sortVowels(String s) {
        String str = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                str += ch;
            }
        } 
        char[] vowelArray = str.toCharArray();
        Arrays.sort(vowelArray);   
        StringBuilder result = new StringBuilder();
        int idx = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                result.append(vowelArray[idx++]);
            }else{
                result.append(ch);
            }
        }
        return result.toString();
    }
    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}