import java.util.Scanner;
public class lightsout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] inputPresses = new int[3][3];
        int[][] totalToggles = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inputPresses[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int presses = inputPresses[i][j];
                if (presses == 0) continue;
                totalToggles[i][j] += presses;
                if (i > 0) totalToggles[i - 1][j] += presses;
                if (i < 2) totalToggles[i + 1][j] += presses; 
                if (j > 0) totalToggles[i][j - 1] += presses;
                if (j < 2) totalToggles[i][j + 1] += presses; 
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (totalToggles[i][j] % 2 == 1) {
                    System.out.print(0);
                } else {
                    System.out.print(1);
                }
            }
            System.out.println(); 
            sc.close();
        }
    }
}