class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = 0;
        int max_size = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                size = j - i + 1;
                max_size = Math.max(max_size, size);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max_size;
    }
}
