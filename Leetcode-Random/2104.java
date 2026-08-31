class Solution {
    public long subArrayRanges(int[] nums) {
        return subArrayMax(nums)-subArrayMin(nums);
    }
    public long subArrayMin(int arr[]){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        long res = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            left[i] = s.isEmpty()?i+1:i-s.peek();
            s.push(i);
        }
        s.clear();
        for(int i = n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n-i : s.peek() - i;
            s.push(i);
        }
        for(int i = 0;i<n;i++){
            res += (long) arr[i]*left[i]*right[i];
        }
        return res;
    }
    public long subArrayMax(int arr[]){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        long res = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                s.pop();
            }
            left[i] = s.isEmpty()?i+1:i-s.peek();
            s.push(i);
        }
        s.clear();
        for(int i = n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n-i : s.peek() - i;
            s.push(i);
        }
        for(int i = 0;i<n;i++){
            res += (long) arr[i]*left[i]*right[i];
        }
        return res;        
    }
}