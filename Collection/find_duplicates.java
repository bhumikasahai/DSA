import java.util.*;
public class find_duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        solve(arr);
    }    
    public static void solve(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                list.add(arr[i]);
            }
            set.add(arr[i]);
        }
        System.out.println(list);
    }
}
