import java.io.*;
import java.util.*;
public class apartments {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] persons = new int[n];
        int[] apartments = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            persons[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            apartments[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(persons);
        Arrays.sort(apartments);
        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            if (apartments[j] < persons[i] - k) {
                j++;                 
            } 
            else if (apartments[j] > persons[i] + k) {
                i++;                 
            } 
            else {
                count++;             
                i++;
                j++;
            }
        }
        System.out.println(count);
    }
}
