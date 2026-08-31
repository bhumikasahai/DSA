class Solution {
    public int maxFreqSum(String s) {
        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }    
        int maxVow = 0;
        int maxConst = 0;
        for(int i=0;i<26;i++){
            if(i==0 || i==4 || i==8 || i==14 || i==20){
                maxVow = Math.max(maxVow, freq[i]);
            }else{
                maxConst = Math.max(maxConst, freq[i]);
            }
        }
        return maxVow + maxConst;
    }
}