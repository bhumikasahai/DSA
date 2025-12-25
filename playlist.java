import java.io.*;
import java.util.*;
public class playlist {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(n, nums));
    }
    public static int solve(int n, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int l = 0, maxLen = 0;
        for (int r = 0; r < n; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                l++;
            }
            set.add(nums[r]);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
