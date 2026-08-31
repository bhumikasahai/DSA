class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int l=0,r=0;
        int n=nums.length;
        while(r<n-1){
            int farthest = 0;
            for(int ind=l;ind<=r;ind++){
                farthest = Math.max(farthest,ind+nums[ind]);
            }
            l = r+1;
            r = farthest;
            jumps += 1;
        }        
        return jumps;
    }
}