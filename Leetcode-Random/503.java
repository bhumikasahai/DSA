class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int res[] = new int[n];
        Arrays.fill(res, -1);
        for(int i=2*n-1;i>=0;i--){
            while(!s.empty() && s.peek()<=arr[i%n]){
                s.pop();
            }
            if(i<n){
                res[i] = s.empty() ? -1 : s.peek();
            }
            s.push(arr[i%n]);
        }        
        return res;
    }
}
