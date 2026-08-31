class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int left = 0, count0 = 0, count1 = 0;
        int result = 0;
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '0') {
                count0++;
            } else {
                count1++;
            }
            while (count0 > k && count1 > k) {
                if (s.charAt(left) == '0') {
                    count0--;
                } else {
                    count1--;
                }
                left++;
            }
            result += (right - left + 1);
        }
        return result;                
    }
}