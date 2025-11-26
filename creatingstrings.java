import java.util.*;
public class creatingstrings {
    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();       
        char[] arr = s.toCharArray();
        Arrays.sort(arr); 
        solve(arr, 0);
        Collections.sort(result);
        System.out.println(result.size());
        for(String str : result){
            System.out.println(str);
        }
    }
    public static void solve(char[] arr, int idx) {
        if(idx == arr.length){
            result.add(new String(arr));
            return;
        }
        HashSet<Character> set = new HashSet<>();      
        for(int i = idx; i < arr.length; i++){
            if(set.contains(arr[i])) continue; 
            set.add(arr[i]);
            swap(arr, idx, i);
            solve(arr, idx+1);
            swap(arr, idx, i); 
        }
    }
    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

    

