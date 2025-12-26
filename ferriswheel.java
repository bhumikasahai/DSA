import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class ferriswheel {
    public static void main(String arags[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cap = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int i = 0;
        int j = n - 1;
        int gondolas = 0;

        while (i <= j) {
            if (arr[i] + arr[j] <= cap) {
                i++;          
            }
            j--;              
            gondolas++;
        }
        System.out.println(gondolas);
    }
}
