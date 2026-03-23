import java.util.*;
public class rangeupdate{
    static long seg[];
    static long lazy[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long arr[] = new long[n];
        seg = new long[4*n];
        lazy = new long[4*n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }
    }
    public static void rangeupdate(int idx, int ql, int qr, int l, int r, int v){    //ql = starting index  qr = ending index
        if(lazy[idx]!=0){
            seg[idx] = (r-l+1)*v;
            if(l!=r){
                lazy[2*idx+1] += v;
                lazy[2*idx+2] += v;
            }
            lazy[idx] = 0;
        }
        
        int mid = l+(r-l)/2;
        rangeupdate(2*idx+1, ql, qr, l, mid, v);
        rangeupdate(idx, ql, qr, mid+1, r, v);
        seg[idx] = seg[2*idx+1]+seg[2*idx+2]; 
        }
    }
    public static int query(int idx, int ql, int qr, int l, int r){
        if(lazy)
    }
}