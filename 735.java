class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int n = asteroids.length;
        for(int i=0;i<n;i++){
            boolean survived = true;
            while(!s.isEmpty() && s.peek()>0 && asteroids[i]<0){
                if(s.peek() > Math.abs(asteroids[i])){
                    survived = false;
                    break;
                }else if(s.peek()==Math.abs(asteroids[i])){
                    s.pop();
                    survived = false;
                    break;
                }else{
                    s.pop();
                }
            }
            if(survived){
                s.push(asteroids[i]);
            }
        }  
        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}