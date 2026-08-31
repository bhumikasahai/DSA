class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int  i=0, j=0, maxlen=0;
        int n = s.length();
        while(j<n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.get(ch)>2){
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }
            maxlen = Math.max(maxlen, j - i + 1);
            j++;
        }  
        return maxlen;      
    }
}