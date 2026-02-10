import java.util.*;
public class girddirections {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char grid[][] = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = sc.next().charAt(0); 
            }
        }
        int currR = 0;
        int currC = 1; 
        int endR = 3;
        int endC = 3; 
        System.out.print("Path: ");
        int steps = 0;
        int maxSteps = row * col * 2; 
        while (steps < maxSteps) {
            System.out.print("(" + currR + "," + currC + ") ");
            if (currR == endR && currC == endC) {
                System.out.println("\nSUCCESS: Reached destination!");
                return;
            }
            char direction = grid[currR][currC];
            if (direction == 'R') {
                currC++;
            } else if (direction == 'L') {
                currC--;
            } else if (direction == 'U') {
                currR--;
            } else if (direction == 'D') {
                currR++;
            }
            if (currR < 0 || currR >= row || currC < 0 || currC >= col) {
                System.out.println("\nFAILED: Went out of bounds.");
                return;
            }
            steps++;
        }
        System.out.println("\nFAILED: Stuck in a loop or path too long.");
    }
}