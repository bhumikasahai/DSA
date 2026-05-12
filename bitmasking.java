import java.util.*;
public class bitmasking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int worker[] = new int[n];
        for (int i = 0; i < n; i++) {
            int days = sc.nextInt();
            int mask = 0;

            for (int j = 0; j < days; j++) {
                mask = mask | (1 << j);
            }

            worker[i] = mask;
        }
        System.out.println("Workers");
        for (int i = 0; i < n; i++) {
            System.out.print("worker works on " + worker[i] + " : ");
            print(worker[i]);
            System.out.println();
        }
        System.out.println
    }
    public static void print(int n) {
        if (n == 0) return;
        print(n / 2);
        System.out.print(n % 2);
    }
    public static int countBit(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }
}