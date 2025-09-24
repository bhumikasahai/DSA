import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int maxlen = 0;
        int max_freq = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            max_freq = Math.max(max_freq, map.get(ch));
            while ((j - i + 1) - max_freq > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                i++;
            }

            maxlen = Math.max(maxlen, j - i + 1);
            j++;
        }
        return maxlen;
    }
}
