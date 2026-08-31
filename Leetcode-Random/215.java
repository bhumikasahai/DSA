class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            maxHeap.add(nums[i]);
        }  
        for(int i = k;i<nums.length;i++){
            if(nums[i]>maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        } 
        int ans = maxHeap.peek();
        return ans;     
    }
}