import java.util.*;
public class moviefestival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int time[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }
        Arrays.sort(time, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int last = time[0][1];
        for(int i=1;i<time.length;i++){
            if(time[i][0]>=last){
                count++;
                last = time[i][1];
            }
        }
        System.out.println(count);
    }
}
