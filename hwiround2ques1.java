import java.util.*;
public class hwiround2ques1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<n;i++){
            if(i%2==0 && arr[i]>=x){
                count1++;
            }
            if(i%2!=0 && arr[i]>=y){
                count2++;
            }
        }
        for(int i=0;i<n;i++){
            if(i%2==0 && arr[i]>=y){
                count1++;
            }
            if(i%2!=0 && arr[i]>=x){
                count2++;
            }
        }
        System.out.println(Math.max(count1,count2));
    }
}
