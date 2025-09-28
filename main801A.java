import java.util.*;
class main801A{
    public static int viciousKeyboard(String str){
        int count = 0;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)=='V' && str.charAt(i+1)=='K'){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        int maxScore = viciousKeyboard(str);
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            char originalChar = arr[i];
            arr[i] = 'V';
            String modifiedV = new String(arr);
            maxScore = Math.max(maxScore, viciousKeyboard(modifiedV));
            arr[i] = 'K';
            String modifiedK = new String(arr);
            maxScore = Math.max(maxScore, viciousKeyboard(modifiedK)); 
            arr[i] = originalChar;
        }
        System.out.println(maxScore);
    }
}