import java.util.*;
public class hitthelotterygreedy{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = {100,20,10,5,1};
        int count = 0;
        for(int c : coins){
            count += n / c;
            n %= c;
        }
        System.out.println(count);
    }
}