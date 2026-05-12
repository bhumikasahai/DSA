import java.util.*;
public class maxnegatesum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int arr[] = new int[7];
            int max = -100;
            for (int i = 0; i < 7; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            int sum = 0;
            boolean flag = false;
            for (int i = 0; i < 7; i++) {
                if (arr[i] == max && !flag) {
                    sum += arr[i];   
                    flag = true;
                } else {
                    sum += -arr[i]; 
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}