class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        Set<Character> brokenset = new HashSet<>();
        for(char c : brokenLetters.toCharArray()){
            brokenset.add(c);
        }
        int count = 0;
        String[] words = text.split(" ");
        for(String word : words){
            boolean canBeTyped = true;
            for(char letter : word.toCharArray()){
                if(brokenset.contains(letter)){
                    canBeTyped = false;
                    break;
                }
            }
            if(canBeTyped){
                count++;
            }
        }
        return count;        
    }
}