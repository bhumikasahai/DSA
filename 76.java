class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] freqT = new int[256]; 
        int[] window = new int[256]; 
        for (char c : t.toCharArray()) {
            freqT[c]++;
        }
        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        while (right < s.length()) {
            char cRight = s.charAt(right);
            window[cRight]++;
            if (freqT[cRight] > 0 && window[cRight] <= freqT[cRight]) {
                required--;
            }
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char cLeft = s.charAt(left);
                window[cLeft]--;
                if (freqT[cLeft] > 0 && window[cLeft] < freqT[cLeft]) {
                    required++;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
